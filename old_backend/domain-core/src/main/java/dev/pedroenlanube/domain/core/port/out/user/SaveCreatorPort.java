package dev.pedroenlanube.domain.core.port.out.user;

import dev.pedroenlanube.domain.core.model.user.User;

import java.util.function.Consumer;

public interface SaveCreatorPort extends Consumer<User> {
}
