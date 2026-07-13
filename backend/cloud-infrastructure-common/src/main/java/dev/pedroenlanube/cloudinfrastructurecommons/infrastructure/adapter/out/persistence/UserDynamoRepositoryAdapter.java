package dev.pedroenlanube.cloudinfrastructurecommons.infrastructure.adapter.out.persistence;

import dev.pedroenlanube.cloudinfrastructurecommons.infrastructure.adapter.out.persistence.entity.UserEntity;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;

@Configuration
public class UserDynamoRepositoryAdapter extends BaseDynamoRepositoryAdapter<UserEntity> {

    public UserDynamoRepositoryAdapter(DynamoDbEnhancedClient client) {
        super(client, UserEntity.class);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return queryByPk("EMAIL#" + email).stream().findFirst();
    }

    public Optional<UserEntity> findBySub(String sub) {
        Key key = Key.builder()
                .partitionValue("USER#" + sub)
                .sortValue("PROFILE")
                .build();
        return findById(key);

    }
}
