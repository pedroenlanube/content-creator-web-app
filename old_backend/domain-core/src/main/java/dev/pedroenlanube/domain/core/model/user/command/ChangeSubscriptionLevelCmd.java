package dev.pedroenlanube.domain.core.model.user.command;

public record ChangeSubscriptionLevelCmd(String subscriberId, String creatorId, String newSubscriptionLevelId) {
}
