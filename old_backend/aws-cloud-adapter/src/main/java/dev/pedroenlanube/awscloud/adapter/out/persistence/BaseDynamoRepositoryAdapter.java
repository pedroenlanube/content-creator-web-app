package dev.pedroenlanube.awscloud.adapter.out.persistence;

import dev.pedroenlanube.domain.core.port.out.repository.QueryableRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class BaseDynamoRepositoryAdapter<T> implements QueryableRepositoryPort<T> {

    protected final DynamoDbEnhancedClient client;
    protected DynamoDbTable<T> table;
    private static final String SINGLE_TABLE_NAME = "pedroenlanube-serverless-web-table-dev";

    protected BaseDynamoRepositoryAdapter(DynamoDbEnhancedClient client) {
        this.client = client;
        this.table = client.table(SINGLE_TABLE_NAME, getTableSchema());
    }

    protected abstract TableSchema<T> getTableSchema();

    @Override
    public void save(T entity) {
        log.info("[BaseDynamoRepositoryAdapter] Saving entity: {}", entity.getClass());
        table.putItem(entity);
    }

    public Optional<T> findByKey(Key key) {
        log.debug("[BaseDynamoRepositoryAdapter] Finding entity by Key");
        return Optional.ofNullable(table.getItem(key));
    }

    public void deleteByKey(Key key) {
        log.debug("[BaseDynamoRepositoryAdapter] Deleting entity by Key");
        table.deleteItem(key);
    }

    public List<T> queryByPk(String pk) {
        log.debug("[BaseDynamoRepositoryAdapter] Querying entities by PK: {}", pk);
        QueryConditional query = QueryConditional.keyEqualTo(
                k -> k.partitionValue(pk)
        );
        return table.query(query).stream()
                .flatMap(page -> page.items().stream())
                .toList();
    }

    public List<T> queryByIndex(String indexName, String pk) {
        log.debug("[BaseDynamoRepositoryAdapter] Querying entities by Index {} with PK: {}", indexName, pk);
        QueryConditional query = QueryConditional.keyEqualTo(
                k -> k.partitionValue(pk)
        );
        return table.index(indexName).query(query).stream()
                .flatMap(page -> page.items().stream())
                .toList();
    }

    public List<T> queryByGsi1(String gsi1Pk) {
        log.debug("[DynamoDB] Querying entities by GSI1 PK: {}", gsi1Pk);
        QueryConditional query = QueryConditional.keyEqualTo(
                k -> k.partitionValue(gsi1Pk)
        );
        return table.query(query)
                .items().stream().toList();
    }

    public List<T> queryByGsi2(String gsi2Pk) {
        log.debug("[DynamoDB] Querying entities by GSI2 PK: {}", gsi2Pk);
        QueryConditional query = QueryConditional.keyEqualTo(
                k -> k.partitionValue(gsi2Pk)
        );
        return table.query(query)
                .items().stream().toList();
    }
}
