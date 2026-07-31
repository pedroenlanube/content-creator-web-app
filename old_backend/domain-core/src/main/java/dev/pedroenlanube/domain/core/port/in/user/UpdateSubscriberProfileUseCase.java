package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.user.command.UpdateSubscriberProfileCmd;

import java.util.function.Consumer;

public interface UpdateSubscriberProfileUseCase extends Consumer<UpdateSubscriberProfileCmd> {
}
