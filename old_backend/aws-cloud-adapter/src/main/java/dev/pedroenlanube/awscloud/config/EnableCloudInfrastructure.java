package dev.pedroenlanube.awscloud.config;

import dev.pedroenlanube.awscloud.adapter.out.persistence.UserDynamoRepositoryAdapter;
import dev.pedroenlanube.awscloud.adapter.out.persistence.config.DynamoDbPrimer;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({
        DynamoDbConfig.class,
        DynamoDbPrimer.class,
        UserDynamoRepositoryAdapter.class
})
public @interface EnableCloudInfrastructure {
}
