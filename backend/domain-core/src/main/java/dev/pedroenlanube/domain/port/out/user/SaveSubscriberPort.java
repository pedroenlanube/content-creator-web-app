package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.user.Subscriber;

import java.util.function.Consumer;

public interface SaveSubscriberPort extends Consumer<Subscriber> {
}
