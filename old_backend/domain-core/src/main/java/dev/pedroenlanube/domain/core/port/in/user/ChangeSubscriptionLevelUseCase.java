package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.user.command.ChangeSubscriptionLevelCmd;

import java.util.function.Consumer;

public interface ChangeSubscriptionLevelUseCase extends Consumer<ChangeSubscriptionLevelCmd> {
}
