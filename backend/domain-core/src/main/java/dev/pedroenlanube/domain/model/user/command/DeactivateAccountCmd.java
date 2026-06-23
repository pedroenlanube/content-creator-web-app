package dev.pedroenlanube.domain.model.user.command;

import dev.pedroenlanube.domain.model.user.UserRole;

public record DeactivateAccountCmd(String userId, UserRole role, String reason) {
}
