package dev.pedroenlanube.domain.model.user;

import dev.pedroenlanube.domain.model.user.vo.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Creator {
    private String id;
    private String username;
    private Email email;
    private String biography;
    private String urlProfileImage;
    private Instant registrationDate;

    public Creator (String id, String username, Email email) {
        this.id = Objects.requireNonNull(id, "The creator ID is mandatory");
        this.email = Objects.requireNonNull(email, "The email is mandaroty");
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("The username is mandatory");
        }
        this.username = username;
        this.registrationDate = Instant.now();
        this.biography = "";
        this.urlProfileImage = null;
    }

    public void updateProfile(String newUsername, String newBiography, String newUrlProfileImage) {
        this.username = Objects.requireNonNull(newUsername, "The username is mandatory");
        this.biography = newBiography != null ? newBiography : this.biography;
        this.urlProfileImage = newUrlProfileImage;
    }
}
