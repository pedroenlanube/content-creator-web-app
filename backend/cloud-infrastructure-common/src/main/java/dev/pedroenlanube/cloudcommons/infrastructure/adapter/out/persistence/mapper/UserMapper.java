package dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.mapper;

import dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity.EntityType;
import dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity.SocialMediaLinkEntity;
import dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity.UserEntity;
import dev.pedroenlanube.domain.model.user.User;
import dev.pedroenlanube.domain.model.user.UserRole;
import dev.pedroenlanube.domain.model.user.SubscriptionTier;
import dev.pedroenlanube.domain.model.user.vo.SocialMediaLink;
import dev.pedroenlanube.domain.model.user.SocialMediaType;
import dev.pedroenlanube.domain.model.user.vo.SecureUrl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    public static final Function<UserEntity, User> toDomain = entity ->
            Optional.ofNullable(entity)
                    .map(UserMapper::createDomainUser)
                    .orElse(null);

    public static final Function<User, UserEntity> toEntity = user ->
            Optional.ofNullable(user)
                    .map(UserMapper::createEntityUser)
                    .orElse(null);

    private static User createDomainUser(UserEntity entity) {

        Set<UserRole> roles = entity.getRoles() != null && !entity.getRoles().isEmpty()
                ? entity.getRoles().stream().map(UserRole::valueOf).collect(Collectors.toSet())
                : Set.of(UserRole.USER);

        SubscriptionTier tier = entity.getSubscriptionTier() != null
                ? SubscriptionTier.valueOf(entity.getSubscriptionTier())
                : SubscriptionTier.NONE;

        List<SocialMediaLink> links = entity.getSocialMediaLinks() != null
                ? entity.getSocialMediaLinks().stream()
                .map(linkEntity -> new SocialMediaLink(
                        SocialMediaType.valueOf(linkEntity.getType()),
                        new SecureUrl(linkEntity.getUrl())))
                .toList()
                : new ArrayList<>();

        return User.reconstitute(
                entity.getSub(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getStatus(),
                entity.getBiography(),
                entity.getAvatarUrl(),
                entity.getBannerUrl(),
                links,
                roles,
                tier,
                entity.getCreatedAt()
        );
    }

    private static UserEntity createEntityUser(User user) {

        List<SocialMediaLinkEntity> linkEntities = user.getSocialMediaLinks() != null
                ? user.getSocialMediaLinks().stream()
                .map(link -> new SocialMediaLinkEntity(
                        link.type().name(),
                        link.url().value()))
                .toList()
                : new ArrayList<>();

        Set<String> rolesStr = user.getRoles().stream()
                .map(Enum::name)
                .collect(Collectors.toSet());

        return UserEntity.builder()
                // --- Single-Table Design Keys ---
                .pk("USER#" + user.getId())
                .sk("PROFILE")
                .gsi1pk("USER#" + user.getId())
                .gsi1sk("PROFILE")
                .gsi2pk("STATUS#" + user.getStatus().name())
                .gsi2sk(user.getCreatedAt().toString())

                // --- Core BaseEntity Attributes ---
                .entityType(EntityType.USER)
                .createdAt(user.getCreatedAt())

                // --- UserEntity Attributes ---
                .sub(user.getId())
                .username(user.getUsername().value())
                .email(user.getEmail().value())
                .status(user.getStatus().name())
                .biography(user.getBiography())
                .avatarUrl(user.getAvatarUrl() != null ? user.getAvatarUrl().value() : null)
                .bannerUrl(user.getBannerUrl() != null ? user.getBannerUrl().value() : null)
                .subscriptionTier(user.getSubscriptionTier().name())
                .roles(rolesStr)
                .socialMediaLinks(linkEntities)
                .build();
    }
}