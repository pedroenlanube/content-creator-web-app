package dev.pedroenlanube.domain.model.coaching.command;

import java.time.Instant;

public record CreateSlotCmd(String creatorId, Instant init, Instant fin) {
}
