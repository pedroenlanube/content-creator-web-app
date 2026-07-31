package dev.pedroenlanube.domain.core.model.subscription.vo;

import java.math.BigDecimal;
import java.util.Objects;

public record Price(BigDecimal amount, String currency) {
    public Price {
        Objects.requireNonNull(amount, "The amount is mandatory");
        Objects.requireNonNull(currency, "The currency is mandatory");
        if(amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("The amount must be a positive number");
        if(currency.isBlank())
            throw new IllegalArgumentException("The currency is mandatory");
    }
}
