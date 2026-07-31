package dev.pedroenlanube.domain.core.model.user;

import dev.pedroenlanube.domain.core.model.user.vo.Email;
import dev.pedroenlanube.domain.core.model.user.vo.SecureUrl;
import dev.pedroenlanube.domain.core.model.user.vo.SocialMediaLink;
import dev.pedroenlanube.domain.core.model.user.vo.Username;
import lombok.Getter;

import java.time.Instant;
import java.util.*;

@Getter
public class User {
    private final String id;
    private Username username;
    private AccountStatus status;
    private Email email;
    private String biography;
    private SecureUrl avatarUrl;
    private SecureUrl bannerUrl;
    private List<SocialMediaLink> socialMediaLinks;
    private final Instant createdAt;
    private Set<UserRole> roles;
    private SubscriptionTier subscriptionTier;

    public User(String id, String username, Email email) {
        this.id = Objects.requireNonNull(id, "The creator ID is mandatory");
        this.username = new Username(username.trim());
        this.email = Objects.requireNonNull(email, "The email is mandatory");
        this.status = AccountStatus.ACTIVE;
        this.createdAt = Instant.now();
        this.socialMediaLinks = List.of();
        this.biography = "";
        this.roles = new HashSet<>(Set.of(UserRole.USER));
        this.subscriptionTier = SubscriptionTier.NONE;
    }

    private User(String id, Username username, AccountStatus status, Email email,
                 String biography, SecureUrl avatarUrl, SecureUrl bannerUrl,
                 List<SocialMediaLink> socialMediaLinks, Instant createdAt,
                 Set<UserRole> roles, SubscriptionTier subscriptionTier) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.email = email;
        this.biography = biography;
        this.avatarUrl = avatarUrl;
        this.bannerUrl = bannerUrl;
        this.socialMediaLinks = socialMediaLinks;
        this.createdAt = createdAt;
        this.roles = roles != null ? roles : new HashSet<>();
        this.subscriptionTier = subscriptionTier;
    }

    public void updateProfile(String newUsername, String newBiography, String newAvatarUrl,
                              List<SocialMediaLink> newSocialMediaLinks, String newBannerUrl) {
        if(this.status != AccountStatus.ACTIVE)
            throw new IllegalStateException("Can't update an inactive profile");
        updateUsername(newUsername);
        if(biography != null && biography.length() > 500)
            throw new IllegalArgumentException("The biography can't be longer than 500 characters");
        this.biography = newBiography != null && !newBiography.isBlank() ? newBiography.trim() : this.biography;
        this.avatarUrl = newAvatarUrl != null ? new SecureUrl(newAvatarUrl) : null;
        this.bannerUrl = newBannerUrl != null ? new SecureUrl(newBannerUrl) : null;
        this.socialMediaLinks = newSocialMediaLinks != null ? new ArrayList<>(newSocialMediaLinks) : new ArrayList<>();
    }

    public void changeEmail(Email newEmail) {
        Objects.requireNonNull(newEmail, "The email can't be null" );
        if(this.status != AccountStatus.ACTIVE)
            throw new IllegalStateException("Can't change the email of an inactive profile");
        if(this.email.equals(newEmail))
            throw new IllegalArgumentException("The email can't be the same");
        this.email = newEmail;
    }

    public void deactivate() {
        this.status = AccountStatus.SUSPENDED;
    }

    private void updateUsername(String newUsername) {
        this.username = new Username(newUsername.trim());
    }

    private void validateSecureUrl(String url) {
        if(url == null || url.isBlank())
            return;

    }

    public void grantRole(UserRole role) {
        this.roles.add(role);
    }

    public void revokeRole(UserRole role) {
        this.roles.remove(role);
    }

    public void upgradeSubscription(SubscriptionTier newTier) {
        if(this.status != AccountStatus.ACTIVE)
            throw new IllegalStateException("Can't upgrade an inactive profile");

        this.subscriptionTier = Objects.requireNonNull(newTier, "Tier cannot be null");
        this.grantRole(UserRole.SUBSCRIBER);
    }

    public void cancelSubscription() {
        this.subscriptionTier = SubscriptionTier.NONE;
        this.revokeRole(UserRole.SUBSCRIBER);
    }

    public static User reconstitute(String id, String username, String email, String status,
                                    String biography, String avatarUrl, String bannerUrl,
                                    List<SocialMediaLink> socialMediaLinks,
                                    Set<UserRole> roles, SubscriptionTier subscriptionTier,
                                    Instant createdAt) {
        return new User(
                id,
                new Username(username),
                AccountStatus.valueOf(status),
                new Email(email),
                biography,
                avatarUrl != null ? new SecureUrl(avatarUrl) : null,
                bannerUrl != null ? new SecureUrl(bannerUrl) : null,
                socialMediaLinks != null ? new ArrayList<>(socialMediaLinks) : new ArrayList<>(),
                createdAt,
                roles,
                subscriptionTier
        );
    }
}
