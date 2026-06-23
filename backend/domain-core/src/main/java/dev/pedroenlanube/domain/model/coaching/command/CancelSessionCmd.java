package dev.pedroenlanube.domain.model.coaching.command;

public record CancelSessionCmd(String sessionId, String subscriberId, String cancelReason) {
}
