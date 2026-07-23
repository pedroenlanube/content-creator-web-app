package dev.pedroenlanube.domain.core.model.user.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsernameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pedro", "pedro_nube", "pedro.nube", "pedro-nube123"})
    @DisplayName("Should accept valid usernames")
    void shouldAcceptValidUsernames(String validUsername) {
        Username username = new Username(validUsername);
        assertThat(username.value()).isEqualTo(validUsername);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "thisusernameiswaytoolongfortherules"})
    @DisplayName("Should reject usernames outside length bounds")
    void shouldRejectInvalidLengths(String invalidLength) {
        assertThatThrownBy(() -> new Username(invalidLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Username must be between 5 and 30 characters");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pedro nube", "pedro@nube", "pedro🚀"})
    @DisplayName("Should reject usernames with invalid characters")
    void shouldRejectInvalidCharacters(String invalidChars) {
        assertThatThrownBy(() -> new Username(invalidChars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Username contains invalid characters");
    }

    @Test
    @DisplayName("Should reject null")
    void shouldRejectNull() {
        assertThatThrownBy(() -> new Username(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Username cannot be null");
    }
}