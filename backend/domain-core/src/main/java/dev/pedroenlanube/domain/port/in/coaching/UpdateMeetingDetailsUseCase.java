package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.UpdateSessionDetailsCmd;

import java.util.function.Consumer;

public interface UpdateMeetingDetailsUseCase extends Consumer<UpdateSessionDetailsCmd> {
}
