package dev.pedroenlanube.domain.model.coaching.command;

public record SubmitFeedbackCmd(String sessionId, String subscriberId, String feedback, Integer stars) {
}
