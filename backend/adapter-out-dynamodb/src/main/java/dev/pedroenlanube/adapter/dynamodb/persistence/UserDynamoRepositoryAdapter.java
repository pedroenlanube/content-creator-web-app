package dev.pedroenlanube.adapter.dynamodb.persistence;

import dev.pedroenlanube.adapter.dynamodb.persistence.entity.user.UserEntity;
import dev.pedroenlanube.adapter.dynamodb.persistence.mapper.UserMapper;
import dev.pedroenlanube.domain.core.port.out.user.DeleteUserPort;
import dev.pedroenlanube.domain.core.port.out.user.FindUserByIdPort;
import dev.pedroenlanube.domain.core.port.out.user.SaveUserPort;
import dev.pedroenlanube.domain.core.port.out.user.UpdateUserPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;

// Marcamos la clase como Dependent (su único ciclo de vida es servir como fábrica)
@Dependent
public class UserDynamoRepositoryAdapter extends BaseDynamoRepositoryAdapter<UserEntity> {

    // En Quarkus, si una clase solo tiene un constructor, CDI inyecta las
    // dependencias automáticamente. Podrías poner @Inject encima, pero es opcional.
    public UserDynamoRepositoryAdapter(DynamoDbEnhancedClient client) {
        super(client);
    }

    @Override
    protected TableSchema<UserEntity> getTableSchema() {
        return TableSchema.fromBean(UserEntity.class);
    }

    // @Produces fabrica el bean. @ApplicationScoped lo hace Singleton.
    @Produces
    @ApplicationScoped
    public SaveUserPort saveUserPort() {
        return user -> save(UserMapper.toEntity.apply(user));
    }

    @Produces
    @ApplicationScoped
    public FindUserByIdPort findUserByIdPort() {
        return sub -> findUserBySub(sub)
                .map(UserMapper.toDomain);
    }

    @Produces
    @ApplicationScoped
    public UpdateUserPort updateUserPort() {
        return user -> save(UserMapper.toEntity.apply(user));
    }

    @Produces
    @ApplicationScoped
    public DeleteUserPort deleteUserPort() {
        return sub -> {
            Key key = Key.builder()
                    .partitionValue("USER#" + sub)
                    .sortValue("PROFILE")
                    .build();
            deleteByKey(key);
        };
    }

    private Optional<UserEntity> findUserBySub(String sub) {
        Key key = Key.builder()
                .partitionValue("USER#" + sub)
                .sortValue("PROFILE")
                .build();
        return findByKey(key);
    }
}