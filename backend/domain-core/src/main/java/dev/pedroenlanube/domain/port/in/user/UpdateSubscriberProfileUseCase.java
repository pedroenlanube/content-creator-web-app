package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.command.UpdateSubscriberProfileCmd;

import java.util.function.Consumer;

public interface UpdateSubscriberProfileUseCase extends Consumer<UpdateSubscriberProfileCmd> {
}
