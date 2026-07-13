package dev.pedroenlanube.cloudinfrastructurecommons.infrastructure.adapter.out.persistence;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.List;
import java.util.Optional;

@Slf4j
public class BaseDynamoRepositoryAdapter<T> {

    protected final DynamoDbTable<T> table;
    private static final String SINGLE_TABLE_NAME = "serverless-back-table";
    private static final String GSI1_NAME = "GSI1";

    protected BaseDynamoRepositoryAdapter(DynamoDbEnhancedClient client, Class<T> entityClass) {
       this.table = client.table(SINGLE_TABLE_NAME, TableSchema.fromBean(entityClass));
    }

    public void save(T entity) {
        log.debug("[DynamoDB] Saving entity: {}", entity.getClass().getSimpleName());
        table.putItem(entity);
    }

    public void delete(T entity) {
        log.debug("[DynamoDB] Deleting entity: {}", entity.getClass().getSimpleName());
        table.deleteItem(entity);
    }

    public Optional<T> findById(Key key) {
        log.debug("[DynamoDB] Finding entity with key: {}", key);
        return Optional.ofNullable(table.getItem(key));
    }

    public List<T> queryByPk(String pk) {
        log.debug("[DynamoDB] Querying entities by PK: {}", pk);
        QueryConditional query = QueryConditional.keyEqualTo(
                k -> k.partitionValue(pk)
        );
        return table.query(query)
                .items().stream().toList();
    }

    public List<T> queryByGsi1(String gsi1Pk) {
        log.debug("[DynamoDB] Querying entities by GSI1 PK: {}", gsi1Pk);
        QueryConditional query = QueryConditional.keyEqualTo(
                k -> k.partitionValue(gsi1Pk)
        );
        return table.query(query)
                .items().stream().toList();
    }
}
