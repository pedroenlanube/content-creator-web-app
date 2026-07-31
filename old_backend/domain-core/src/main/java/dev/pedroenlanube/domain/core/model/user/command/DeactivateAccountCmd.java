package dev.pedroenlanube.domain.core.model.user.command;

import dev.pedroenlanube.domain.core.model.user.UserRole;

public record DeactivateAccountCmd(String userId, UserRole role, String reason) {
}
