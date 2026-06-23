package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.command.ChangeSubscriptionLevelCmd;

import java.util.function.Consumer;

public interface ChangeSubscriptionLevelUseCase extends Consumer<ChangeSubscriptionLevelCmd> {
}
