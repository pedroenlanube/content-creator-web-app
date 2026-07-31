package dev.pedroenlanube.domain.core.model.coaching.command;

public record SubmitFeedbackCmd(String sessionId, String subscriberId, String feedback, Integer stars) {
}
