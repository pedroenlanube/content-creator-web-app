package dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;
import java.util.Set;

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
    private String biography;
    private String avatarUrl;
    private String bannerUrl;
    private Set<String> roles;
    private String subscriptionTier;
    private List<SocialMediaLinkEntity> socialMediaLinks;
}
