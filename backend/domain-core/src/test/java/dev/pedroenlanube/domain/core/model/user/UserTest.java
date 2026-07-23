package dev.pedroenlanube.domain.core.model.user;

import dev.pedroenlanube.domain.core.model.user.vo.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    private User activeUser;
    private final String VALID_ID = "usr_12345";
    private final String VALID_USERNAME = "pedroenlanube";
    private Email validEmail;

    @BeforeEach
    void setUp() {
        validEmail = new Email("test@domain.com");
        activeUser = new User(VALID_ID, VALID_USERNAME, validEmail);
    }

    @Test
    @DisplayName("Should construct a new valid user with default values")
    void shouldConstructValidUser() {
        assertThat(activeUser.getId()).isEqualTo(VALID_ID);
        assertThat(activeUser.getUsername().value()).isEqualTo(VALID_USERNAME);
        assertThat(activeUser.getEmail()).isEqualTo(validEmail);
        assertThat(activeUser.getStatus()).isEqualTo(AccountStatus.ACTIVE);
        assertThat(activeUser.getRoles()).containsExactly(UserRole.USER);
        assertThat(activeUser.getSubscriptionTier()).isEqualTo(SubscriptionTier.NONE);
        assertThat(activeUser.getCreatedAt()).isNotNull();
    }

    @Test
    @DisplayName("Constructor should reject null ID or Email")
    void constructorShouldRejectNulls() {
        assertThatThrownBy(() -> new User(null, VALID_USERNAME, validEmail))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The creator ID is mandatory");

        assertThatThrownBy(() -> new User(VALID_ID, VALID_USERNAME, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The email is mandatory");
    }

    @Test
    @DisplayName("Should update profile successfully")
    void shouldUpdateProfile() {
        activeUser.updateProfile(
                "new_handle",
                "New bio",
                "https://example.com/avatar.png",
                null,
                "https://example.com/banner.png"
        );

        assertThat(activeUser.getUsername().value()).isEqualTo("new_handle");
        assertThat(activeUser.getBiography()).isEqualTo("New bio");
        assertThat(activeUser.getAvatarUrl().value()).isEqualTo("https://example.com/avatar.png");
        assertThat(activeUser.getBannerUrl().value()).isEqualTo("https://example.com/banner.png");
    }

    @Test
    @DisplayName("Should not update profile if user is suspended")
    void shouldNotUpdateIfSuspended() {
        activeUser.deactivate();

        assertThatThrownBy(() -> activeUser.updateProfile("new_handle", "bio", null, null, null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Can't update an inactive profile");
    }

    @Test
    @DisplayName("Should change email successfully")
    void shouldChangeEmail() {
        Email newEmail = new Email("new@domain.com");
        activeUser.changeEmail(newEmail);

        assertThat(activeUser.getEmail()).isEqualTo(newEmail);
    }

    @Test
    @DisplayName("Should not change email if inactive or same email")
    void shouldRejectEmailChangeConditions() {
        assertThatThrownBy(() -> activeUser.changeEmail(validEmail))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The email can't be the same");

        activeUser.deactivate();
        Email newEmail = new Email("new@domain.com");

        assertThatThrownBy(() -> activeUser.changeEmail(newEmail))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Can't change the email of an inactive profile");
    }

    @Test
    @DisplayName("Should manage subscription and roles correctly")
    void shouldManageSubscription() {
        activeUser.upgradeSubscription(SubscriptionTier.TIER_3); // Asumiendo TIER_3 existe

        assertThat(activeUser.getSubscriptionTier()).isEqualTo(SubscriptionTier.TIER_3);
        assertThat(activeUser.getRoles()).contains(UserRole.SUBSCRIBER);

        activeUser.cancelSubscription();

        assertThat(activeUser.getSubscriptionTier()).isEqualTo(SubscriptionTier.NONE);
        assertThat(activeUser.getRoles()).doesNotContain(UserRole.SUBSCRIBER);
    }

    @Test
    @DisplayName("Should not upgrade subscription if inactive")
    void shouldNotUpgradeIfInactive() {
        activeUser.deactivate();

        assertThatThrownBy(() -> activeUser.upgradeSubscription(SubscriptionTier.TIER_3))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Can't upgrade an inactive profile");
    }
}