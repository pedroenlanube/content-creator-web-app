package dev.pedroenlanube.ctx.coaching.strategy;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.model.coaching.SessionType;
import dev.pedroenlanube.domain.model.coaching.command.ReserveSessionCmd;
import dev.pedroenlanube.domain.port.in.strategy.DomainConsumerStrategy;
import dev.pedroenlanube.domain.port.out.coaching.LoadSessionPort;
import dev.pedroenlanube.domain.port.out.coaching.SaveSessionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AsyncDeckReviewStrategy implements DomainConsumerStrategy<ReserveSessionCmd> {

    private final LoadSessionPort loadPort;
    private final SaveSessionPort savePort;

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
