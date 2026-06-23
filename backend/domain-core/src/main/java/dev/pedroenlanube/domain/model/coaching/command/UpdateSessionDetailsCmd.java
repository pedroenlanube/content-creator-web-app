package dev.pedroenlanube.domain.model.coaching.command;

public record UpdateSessionDetailsCmd(String sessionId, String creatorId, String previousNotes) {
}
