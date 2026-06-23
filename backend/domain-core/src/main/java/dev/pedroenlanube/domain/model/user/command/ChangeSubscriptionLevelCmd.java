package dev.pedroenlanube.domain.model.user.command;

public record ChangeSubscriptionLevelCmd(String subscriberId, String creatorId, String newSubscriptionLevelId) {
}
