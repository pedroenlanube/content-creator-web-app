package dev.pedroenlanube.domain.core.model.coaching.command;

public record UpdateSessionDetailsCmd(String sessionId, String creatorId, String previousNotes) {
}
