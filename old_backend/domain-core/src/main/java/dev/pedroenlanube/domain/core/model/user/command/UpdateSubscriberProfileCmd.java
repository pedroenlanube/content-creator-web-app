package dev.pedroenlanube.domain.core.model.user.command;

public record UpdateSubscriberProfileCmd(String subscriberId, String username, String avatarUrl) {
}
