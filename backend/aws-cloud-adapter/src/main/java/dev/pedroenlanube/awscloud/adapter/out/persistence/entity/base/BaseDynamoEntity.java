package dev.pedroenlanube.awscloud.adapter.out.persistence.entity.base;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.Instant;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseDynamoEntity {
    private String pk;
    private String sk;
    private String gsi1pk;
    private String gsi1sk;
    private String gsi2pk;
    private String gsi2sk;
    private EntityType entityType;
    private Instant createdAt;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("PK")
    public String getPk() { return pk; }

    @DynamoDbSortKey
    @DynamoDbAttribute("SK")
    public String getSk() { return sk; }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI1"})
    @DynamoDbAttribute("GSI1PK")
    public String getGsi1pk() { return gsi1pk; }

    @DynamoDbSecondarySortKey(indexNames = {"GSI1"})
    @DynamoDbAttribute("GSI1SK")
    public String getGsi1sk() { return gsi1sk; }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI2"})
    @DynamoDbAttribute("GSI2PK")
    public String getGsi2pk() { return gsi2pk; }

    @DynamoDbSecondarySortKey(indexNames = {"GSI2"})
    @DynamoDbAttribute("GSI2SK")
    public String getGsi2sk() { return gsi2sk; }

    @DynamoDbAttribute("entityType")
    public EntityType getEntityType() { return entityType; }

    @DynamoDbAttribute("createdAt")
    public Instant getCreatedAt() { return createdAt; }
}
