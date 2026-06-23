package dev.pedroenlanube.domain.model.user.command;

import dev.pedroenlanube.domain.model.user.UserRole;

public record RegisterUserCmd(String id, String email, String username, UserRole role) {
}
