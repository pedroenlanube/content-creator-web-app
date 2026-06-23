package dev.pedroenlanube.domain.port.out.coaching;

import dev.pedroenlanube.domain.model.coaching.event.CoachingNotification;

import java.util.function.Consumer;

public interface NotifyParticipantPort extends Consumer<CoachingNotification> {
}
