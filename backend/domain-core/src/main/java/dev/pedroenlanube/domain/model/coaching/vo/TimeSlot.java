package dev.pedroenlanube.domain.model.coaching.vo;

import java.time.Instant;
import java.util.Objects;

public record TimeSlot(Instant init, Instant end) {
    public TimeSlot {
        Objects.requireNonNull(init, "The init date is mandatory");
        Objects.requireNonNull(end, "The end date is mandatory");

        if(end.isBefore(init) || end.equals(init))
            throw new IllegalArgumentException("The end date must be after the init date");
    }
}
