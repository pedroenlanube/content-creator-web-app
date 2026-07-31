package dev.pedroenlanube.domain.core.model.user.event;

import dev.pedroenlanube.domain.core.model.user.UserRole;

public record UserEventNotification(String userId, UserRole role, String eventType, String details) {
}
