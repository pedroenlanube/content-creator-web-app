package dev.pedroenlanube.domain.core.port.out.coaching;

import dev.pedroenlanube.domain.core.model.coaching.event.CoachingNotification;

import java.util.function.Consumer;

public interface NotifyParticipantPort extends Consumer<CoachingNotification> {
}
