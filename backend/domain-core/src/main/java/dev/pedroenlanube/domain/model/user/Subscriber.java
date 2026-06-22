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
public class Subscriber {
    private String id;
    private String username;
    private Email email;
    private Instant registrationDate;

    public Subscriber(String id, String username, Email email) {
        this.id = Objects.requireNonNull(id, "The subscriber ID is mandatory");
        this.email = Objects.requireNonNull(email, "The email is mandaroty");
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("The username is mandatory");
        }
        this.username = username;
        this.registrationDate = Instant.now();
    }
}
