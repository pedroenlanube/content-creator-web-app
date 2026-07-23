package dev.pedroenlanube.domain.core.model.user.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SecureUrlTest {

    @ParameterizedTest
    @ValueSource(strings = {"https://example.com", "http://sub.domain.org/path?query=1", "https://pedroenlanube.dev"})
    @DisplayName("Should accept valid secure URLs")
    void shouldAcceptValidUrls(String validUrl) {
        SecureUrl url = new SecureUrl(validUrl);
        assertThat(url.value()).isEqualTo(validUrl); // El constructor actual no asigna el trimmed al value, guarda el original
    }

    @ParameterizedTest
    @ValueSource(strings = {"ftp://example.com", "example.com", "htt://wrong.com"})
    @DisplayName("Should reject invalid URL formats")
    void shouldRejectInvalidUrls(String invalidUrl) {
        assertThatThrownBy(() -> new SecureUrl(invalidUrl))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid URL format. Must start with http:// or https://");
    }

    @Test
    @DisplayName("Should reject null or empty URLs")
    void shouldRejectNullOrEmpty() {
        assertThatThrownBy(() -> new SecureUrl(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("URL cannot be null");

        assertThatThrownBy(() -> new SecureUrl("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("URL cannot be empty");
    }
}