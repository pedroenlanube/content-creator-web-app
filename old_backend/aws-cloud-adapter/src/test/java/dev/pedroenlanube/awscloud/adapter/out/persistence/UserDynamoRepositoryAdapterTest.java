package dev.pedroenlanube.awscloud.adapter.out.persistence;

import dev.pedroenlanube.awscloud.adapter.out.persistence.entity.user.UserEntity;
import dev.pedroenlanube.domain.core.model.user.User;
import dev.pedroenlanube.domain.core.model.user.vo.Email;
import dev.pedroenlanube.domain.core.port.out.user.SaveUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDynamoRepositoryAdapterTest {

    @Mock
    private DynamoDbEnhancedClient enhancedClient;

    @Mock
    private DynamoDbTable<UserEntity> userTable;

    private UserDynamoRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        // Configuramos el mock para que devuelva nuestra tabla simulada cuando el adaptador llame a client.table(...)
        when(enhancedClient.table(anyString(), any(TableSchema.class))).thenReturn(userTable);
        adapter = new UserDynamoRepositoryAdapter(enhancedClient);
    }

    @Test
    void saveUserPort_shouldMapDomainToEntityAndSave() {
        // Arrange
        SaveUserPort port = adapter.saveUserPort();
        User domainUser = new User("id71263421", "pedroenlanube", new Email("test@example.com"));

        // Act
        port.accept(domainUser);

        // Assert
        // Verificamos que se llamó a la operación de guardado (asumo que tu BaseDynamoRepositoryAdapter
        // delega en un table.putItem() en su método save())
        verify(userTable, times(1)).putItem(any(UserEntity.class));
    }
}
