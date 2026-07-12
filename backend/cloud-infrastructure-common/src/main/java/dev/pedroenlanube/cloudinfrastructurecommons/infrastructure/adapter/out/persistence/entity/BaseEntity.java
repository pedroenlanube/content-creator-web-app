package dev.pedroenlanube.cloudinfrastructurecommons.infrastructure.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

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
}
