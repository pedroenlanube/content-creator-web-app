package dev.pedroenlanube.domain.model.user;

import dev.pedroenlanube.domain.model.user.vo.Email;
import dev.pedroenlanube.domain.model.user.vo.SecureUrl;
import dev.pedroenlanube.domain.model.user.vo.Username;
import lombok.Getter;

import java.time.Instant;
import java.util.Objects;

@Getter
public class Subscriber {
    private final String id;
    private Username username;
    private Email email;
    private AccountStatus status;
    private final Instant createdAt;
    private SecureUrl avatarUrl;

    public Subscriber(String id, String username, Email email) {
        this.id = Objects.requireNonNull(id, "The subscriber ID is mandatory");
        this.username = new Username(username.trim());
        this.email = Objects.requireNonNull(email, "The email is mandatory");
        this.createdAt = Instant.now();
        this.status = AccountStatus.ACTIVE;
    }

    public void updateProfile(String newUsername, String avatarUrl) {
        if (this.status != AccountStatus.ACTIVE)
            throw new IllegalStateException("Cannot update an inactive profile");
        this.username = new Username(newUsername.trim());
        this.avatarUrl = avatarUrl != null ? new SecureUrl(avatarUrl) : null;
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
}
