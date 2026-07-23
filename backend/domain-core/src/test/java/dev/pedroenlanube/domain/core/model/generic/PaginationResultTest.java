package dev.pedroenlanube.domain.core.model.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PaginationResultTest {

    @Test
    @DisplayName("Should initialize properly with valid data")
    void shouldInitializeWithValidData() {
        List<String> items = List.of("item1", "item2");
        PaginationResult<String> result = new PaginationResult<>(items, 2);

        assertThat(result.items()).containsExactlyElementsOf(items);
        assertThat(result.total()).isEqualTo(2);
    }

    @Test
    @DisplayName("Should default null items to empty list and invalid total to 0")
    void shouldHandleNullsAndNegatives() {
        PaginationResult<String> result = new PaginationResult<>(null, null);

        assertThat(result.items()).isEmpty();
        assertThat(result.total()).isZero();

        PaginationResult<String> negativeTotalResult = new PaginationResult<>(List.of(), -5);
        assertThat(negativeTotalResult.total()).isZero();
    }
}