package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.user.event.UserEventNotification;

import java.util.function.Consumer;

public interface PublishUserEventPort extends Consumer<UserEventNotification> {
}
