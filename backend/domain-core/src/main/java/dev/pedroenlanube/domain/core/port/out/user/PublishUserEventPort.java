package dev.pedroenlanube.domain.core.port.out.user;

import dev.pedroenlanube.domain.core.model.user.event.UserEventNotification;

import java.util.function.Consumer;

public interface PublishUserEventPort extends Consumer<UserEventNotification> {
}
