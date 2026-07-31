package dev.pedroenlanube.domain.core.model.user.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {

    @Test
    @DisplayName("Should create a valid email and transform to lowercase and trim")
    void shouldCreateValidEmail() {
        Email email = new Email("  Test.User@EXAMPLE.com  ");
        assertThat(email.value()).isEqualTo("test.user@example.com");
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@domain.com", "user.name@domain.co.uk", "user+label@domain.io"})
    @DisplayName("Should accept valid email formats")
    void shouldAcceptValidEmailFormats(String validEmail) {
        Email email = new Email(validEmail);
        assertThat(email.value()).isEqualTo(validEmail);
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid-email", "user@.com", "@domain.com", "user@domain", "user@domain..com"})
    @DisplayName("Should reject invalid email formats")
    void shouldRejectInvalidEmailFormats(String invalidEmail) {
        assertThatThrownBy(() -> new Email(invalidEmail))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The email format is not valid");
    }

    @Test
    @DisplayName("Should reject null or blank emails")
    void shouldRejectNullOrBlank() {
        assertThatThrownBy(() -> new Email(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The email can't be null");

        assertThatThrownBy(() -> new Email("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The email format is not valid");
    }
}