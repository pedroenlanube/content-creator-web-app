package dev.pedroenlanube.domain.core.model.coaching.command;

public record CancelSessionCmd(String sessionId, String subscriberId, String cancelReason) {
}
