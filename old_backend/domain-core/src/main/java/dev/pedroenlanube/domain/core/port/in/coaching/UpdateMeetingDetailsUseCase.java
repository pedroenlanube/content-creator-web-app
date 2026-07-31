package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.UpdateSessionDetailsCmd;

import java.util.function.Consumer;

public interface UpdateMeetingDetailsUseCase extends Consumer<UpdateSessionDetailsCmd> {
}
