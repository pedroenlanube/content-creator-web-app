package dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.extensions.annotations.DynamoDbVersionAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.Instant;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@DynamoDbBean
public class BaseEntity {
    private String pk;
    private String sk;
    private String gsi1pk;
    private String gsi1sk;
    private String gsi2pk;
    private String gsi2sk;

    // -- Core Attributes
    private EntityType entityType;
    private Long version;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("pk")
    public String getPk() { return pk; }

    @DynamoDbSortKey
    @DynamoDbAttribute("sk")
    public String getSk() { return sk; }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI1"})
    @DynamoDbAttribute("gsi1pk")
    public String getGsi1pk() { return gsi1pk; }

    @DynamoDbSecondarySortKey(indexNames = {"GSI1"})
    @DynamoDbAttribute("gsi1sk")
    public String getGsi1sk() { return gsi1sk; }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI2"})
    @DynamoDbAttribute("gsi2pk")
    public String getGsi2pk() { return gsi2pk; }

    @DynamoDbSecondarySortKey(indexNames = {"GSI2"})
    @DynamoDbAttribute("gsi2sk")
    public String getGsi2sk() { return gsi2sk; }

    @DynamoDbAttribute("entityType")
    public EntityType getEntityType() { return entityType; }

    @DynamoDbVersionAttribute
    @DynamoDbAttribute("version")
    public Long getVersion() { return version; }

    @DynamoDbAttribute("createdAt")
    public Instant getCreatedAt() { return createdAt; }

    @DynamoDbAttribute("updatedAt")
    public Instant getUpdatedAt() { return updatedAt; }

    @DynamoDbAttribute("deletedAt")
    public Instant getDeletedAt() { return deletedAt; }
}
