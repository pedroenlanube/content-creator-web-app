package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.user.User;

import java.util.function.Consumer;

public interface SaveCreatorPort extends Consumer<User> {
}
