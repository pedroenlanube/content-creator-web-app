package dev.pedroenlanube.domain.core.model.user.command;

import dev.pedroenlanube.domain.core.model.user.UserRole;

public record RegisterUserCmd(String id, String email, String username, UserRole role) {
}
