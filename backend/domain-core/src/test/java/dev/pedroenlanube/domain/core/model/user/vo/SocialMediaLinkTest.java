package dev.pedroenlanube.domain.core.model.user.vo;

import dev.pedroenlanube.domain.core.model.user.SocialMediaType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SocialMediaLinkTest {

    @Test
    @DisplayName("Should create valid SocialMediaLink")
    void shouldCreateValidLink() {
        // Usamos un mock para el enum o clase SocialMediaType ya que no está definida en el código proporcionado
        SocialMediaType dummyType = Mockito.mock(SocialMediaType.class);
        SecureUrl url = new SecureUrl("https://twitter.com/pedroenlanube");

        SocialMediaLink link = new SocialMediaLink(dummyType, url);

        assertThat(link.type()).isEqualTo(dummyType);
        assertThat(link.url()).isEqualTo(url);
    }

    @Test
    @DisplayName("Should reject null type or url")
    void shouldRejectNulls() {
        SocialMediaType dummyType = Mockito.mock(SocialMediaType.class);
        SecureUrl url = new SecureUrl("https://twitter.com");

        assertThatThrownBy(() -> new SocialMediaLink(null, url))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The social media type is mandatory");

        assertThatThrownBy(() -> new SocialMediaLink(dummyType, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The social media URL is mandatory");
    }
}