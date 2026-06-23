package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.SubmitFeedbackCmd;

import java.util.function.Consumer;

public interface SubmitFeedbackUseCase extends Consumer<SubmitFeedbackCmd> {
}
