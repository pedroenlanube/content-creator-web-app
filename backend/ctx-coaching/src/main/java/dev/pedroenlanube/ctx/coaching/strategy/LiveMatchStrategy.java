package dev.pedroenlanube.ctx.coaching.strategy;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.model.coaching.SessionType;
import dev.pedroenlanube.domain.model.coaching.command.ReserveSessionCmd;
import dev.pedroenlanube.domain.port.in.strategy.DomainConsumerStrategy;
import dev.pedroenlanube.domain.port.out.coaching.LoadSessionPort;
import dev.pedroenlanube.domain.port.out.coaching.SaveSessionPort;
import org.springframework.stereotype.Component;

@Component
public class LiveMatchStrategy implements DomainConsumerStrategy<ReserveSessionCmd> {

    private final LoadSessionPort loadPort;
    private final SaveSessionPort savePort;

    public LiveMatchStrategy(LoadSessionPort loadPort, SaveSessionPort savePort) {
        this.loadPort = loadPort;
        this.savePort = savePort;
    }

    @Override
    public boolean isApplicable(ReserveSessionCmd cmd) {
        return cmd.type() == SessionType.LIVE_MATCH;
    }

    @Override
    public void execute(ReserveSessionCmd cmd) {
        CoachingSession session = loadPort.apply(cmd.sessionId())
                .orElseThrow(() -> new IllegalArgumentException("Coaching session not found: " + cmd.sessionId()));

        session.reserveForLiveMatch(cmd.subscriberId());

        savePort.accept(session);
    }
}
