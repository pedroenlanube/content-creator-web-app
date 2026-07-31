package dev.pedroenlanube.ctx.coaching.strategy;

import dev.pedroenlanube.domain.core.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.core.model.coaching.SessionType;
import dev.pedroenlanube.domain.core.model.coaching.command.ReserveSessionCmd;
import dev.pedroenlanube.domain.core.port.in.strategy.DomainConsumerStrategy;
import dev.pedroenlanube.domain.core.port.out.coaching.LoadSessionPort;
import dev.pedroenlanube.domain.core.port.out.coaching.SaveSessionPort;
import org.springframework.stereotype.Component;

@Component
public class AsyncDeckReviewStrategy implements DomainConsumerStrategy<ReserveSessionCmd> {

    private final LoadSessionPort loadPort;
    private final SaveSessionPort savePort;

    public AsyncDeckReviewStrategy(LoadSessionPort loadPort, SaveSessionPort savePort) {
        this.loadPort = loadPort;
        this.savePort = savePort;
    }

    @Override
    public boolean isApplicable(ReserveSessionCmd cmd) {
        return cmd.type() == SessionType.ASYNC_REVIEW;
    }

    @Override
    public void execute(ReserveSessionCmd cmd) {
        if(cmd.resourceUrl() == null)
            throw new IllegalArgumentException("Resource URL cannot be null");

        CoachingSession session = loadPort.apply(cmd.sessionId())
                .orElseThrow(() -> new IllegalArgumentException("Coaching session not found: " + cmd.sessionId()));

        session.reserveForAsyncReview(cmd.subscriberId(), cmd.resourceUrl());

        savePort.accept(session);
    }
}
