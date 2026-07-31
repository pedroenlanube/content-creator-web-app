package dev.pedroenlanube.domain.core.model.coaching.command;

import dev.pedroenlanube.domain.core.model.coaching.SessionType;
import dev.pedroenlanube.domain.core.model.user.vo.SecureUrl;

import java.util.Objects;

public record ReserveSessionCmd(String sessionId, String subscriberId, SessionType type, SecureUrl resourceUrl) {
    public ReserveSessionCmd {
        Objects.requireNonNull(sessionId, "Session ID cannot be null");
        Objects.requireNonNull(subscriberId, "Subscriber ID cannot be null");
        Objects.requireNonNull(type, "Session Type cannot be null");
    }
}
