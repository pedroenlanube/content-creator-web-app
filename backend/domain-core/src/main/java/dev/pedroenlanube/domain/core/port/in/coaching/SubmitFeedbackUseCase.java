package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.SubmitFeedbackCmd;

import java.util.function.Consumer;

public interface SubmitFeedbackUseCase extends Consumer<SubmitFeedbackCmd> {
}
