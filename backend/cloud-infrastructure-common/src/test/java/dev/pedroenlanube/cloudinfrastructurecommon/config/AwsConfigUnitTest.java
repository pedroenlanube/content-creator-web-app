package dev.pedroenlanube.cloudinfrastructurecommon.config;

import dev.pedroenlanube.cloudcommons.infrastructure.config.AwsConfig;
import dev.pedroenlanube.cloudcommons.infrastructure.config.DynamoDbConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.ssm.SsmClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AwsConfigUnitTest {

    @BeforeAll
    static void setUp() {
        // Trick the AWS SDK by injecting system properties so that
        // default constructors (.build()) don't fail looking for credentials.
        System.setProperty("aws.region", "eu-west-1");
        System.setProperty("aws.accessKeyId", "dummy-access-key");
        System.setProperty("aws.secretAccessKey", "dummy-secret-key");
    }

    @AfterAll
    static void tearDown() {
        // Clean up system properties after tests execution
        System.clearProperty("aws.region");
        System.clearProperty("aws.accessKeyId");
        System.clearProperty("aws.secretAccessKey");
    }

    @Test
    void shouldCreateAwsSsmClient() {
        AwsConfig config = new AwsConfig();
        SsmClient client = config.ssmClient();

        assertNotNull(client, "The real SsmClient should be instantiated without errors");
    }

    @Test
    void shouldCreateDynamoDbClients() {
        DynamoDbConfig config = new DynamoDbConfig();

        DynamoDbClient client = config.dynamoDbClient();
        assertNotNull(client, "The real DynamoDbClient should be instantiated without errors");

        DynamoDbEnhancedClient enhancedClient = config.dynamoDbEnhancedClient(client);
        assertNotNull(enhancedClient, "The real DynamoDbEnhancedClient should be instantiated without errors");
    }
}