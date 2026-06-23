package dev.pedroenlanube.domain.model.user.event;

import dev.pedroenlanube.domain.model.user.UserRole;

public record UserEventNotification(String userId, UserRole role, String eventType, String details) {
}
