package dev.pedroenlanube.cloudinfrastructurecommons.infrastructure.adapter.out.persistence.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@DynamoDbBean
public class UserEntity extends BaseEntity {
    private String sub;
    private String username;
    private String email;
    private String status;
    private String createdAt;
}
