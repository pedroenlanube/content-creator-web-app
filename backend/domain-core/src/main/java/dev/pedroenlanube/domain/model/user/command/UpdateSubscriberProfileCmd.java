package dev.pedroenlanube.domain.model.user.command;

public record UpdateSubscriberProfileCmd(String subscriberId, String username, String avatarUrl) {
}
