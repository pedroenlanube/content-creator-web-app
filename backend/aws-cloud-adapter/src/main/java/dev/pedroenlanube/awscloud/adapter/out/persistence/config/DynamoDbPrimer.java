package dev.pedroenlanube.awscloud.adapter.out.persistence.config;

import dev.pedroenlanube.awscloud.adapter.out.persistence.entity.user.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Slf4j
@Component
public class DynamoDbPrimer {

    private final DynamoDbEnhancedClient enhancedClient;
    private final String tableName;

    public DynamoDbPrimer(
            DynamoDbEnhancedClient enhancedClient,
            @Value("${DYNAMODB_TABLE_NAME}") String tableName) {
        this.enhancedClient = enhancedClient;
        this.tableName = tableName;
    }

    /**
     * Este método se ejecuta automáticamente en cuanto el contexto de Spring
     * termina de arrancar. En un entorno SnapStart, esto ocurre durante la
     * fase de despliegue (INIT), ANTES de que AWS congele la memoria.
     */
    @EventListener(ContextRefreshedEvent.class)
    public void primeConnectionOnStartup() {
        log.info("[Priming] Forcing socket opening and TLS tunnelling with DynamoDB...");
        try {
            DynamoDbTable<UserEntity> userTable = enhancedClient.table(tableName, TableSchema.fromBean(UserEntity.class));
            Key dummyKey = Key.builder()
                    .partitionValue("WARMUP#DUMMY")
                    .sortValue("WARMUP#DUMMY")
                    .build();
            // Lanzamos la petición real para obligar al cliente HTTP a abrir el pool
            userTable.getItem(dummyKey);



            log.info("[Priming] DynamoDB connections are hot and ready to be frozen!");
        } catch (Exception e) {
            log.warn("[Priming] Expected error during priming (ignored): {}", e.getMessage());
        }
    }


}
