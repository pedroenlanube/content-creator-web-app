package dev.pedroenlanube.domain.model.user;

import dev.pedroenlanube.domain.model.user.vo.Email;
import dev.pedroenlanube.domain.model.user.vo.SecureUrl;
import dev.pedroenlanube.domain.model.user.vo.SocialMediaLink;
import dev.pedroenlanube.domain.model.user.vo.Username;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Creator {
    private final String id;
    private Username username;
    private AccountStatus status;
    private Email email;
    private String biography;
    private SecureUrl avatarUrl;
    private SecureUrl bannerUrl;
    private List<SocialMediaLink> socialMediaLinks;
    private final Instant createdAt;

    public Creator (String id, String username, Email email) {
        this.id = Objects.requireNonNull(id, "The creator ID is mandatory");
        this.username = new Username(username.trim());
        this.email = Objects.requireNonNull(email, "The email is mandatory");
        this.status = AccountStatus.ACTIVE;
        this.createdAt = Instant.now();
        this.socialMediaLinks = List.of();
        this.biography = "";
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
}
