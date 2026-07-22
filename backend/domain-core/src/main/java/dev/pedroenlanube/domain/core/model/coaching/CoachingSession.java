package dev.pedroenlanube.domain.core.model.coaching;

import dev.pedroenlanube.domain.core.model.coaching.vo.TimeSlot;
import dev.pedroenlanube.domain.core.model.user.vo.SecureUrl;
import lombok.Getter;

import java.util.Objects;

@Getter
public class CoachingSession {
    private final String id;
    private final String creatorId;
    private String subscriberId;
    private TimeSlot slot;
    private CoachingState state;
    private SessionType type;
    private SecureUrl resourceUrl;
    private String feedback;
    private String previousNotes;

    public CoachingSession(String id, String creatorId, TimeSlot slot) {
        this.id = Objects.requireNonNull(id, "The coaching session ID is mandatory");
        this.creatorId = Objects.requireNonNull(creatorId, "The creator ID is mandatory");
        this.slot = Objects.requireNonNull(slot, "The time slot is mandatory");
        this.state = CoachingState.AVAILABLE;
        this.subscriberId = null;
        this.type = null;
        this.resourceUrl = null;
    }

    public void reserveForLiveMatch(String subscriberId) {
        ensureIsAvailable();

        this.subscriberId = Objects.requireNonNull(subscriberId, "The subscriber ID is mandatory");
        this.type = SessionType.LIVE_MATCH;
        this.state = CoachingState.BOOKED;
    }

    public void reserveForAsyncReview(String subscriberId, SecureUrl resourceUrl) {
        ensureIsAvailable();

        this.subscriberId = Objects.requireNonNull(subscriberId, "The subscriber ID is mandatory");
        this.resourceUrl = Objects.requireNonNull(resourceUrl, "The resource URL is mandatory for async reviews");
        this.type = SessionType.ASYNC_REVIEW;
        this.state = CoachingState.BOOKED;
    }

    private void ensureIsAvailable() {
        if (this.state != CoachingState.AVAILABLE)
            throw new IllegalStateException("The coaching session is not available (Current state: " + this.state + ")");
    }

    public void cancel() {
        if(this.state.equals(CoachingState.CANCELLED))
            throw new IllegalStateException("The coaching session is already cancelled");
        if(this.state.equals(CoachingState.COMPLETED))
            throw new IllegalStateException("The coaching session is already completed");
        this.subscriberId = null;
        this.type = null;
        this.resourceUrl = null;
        this.state = CoachingState.AVAILABLE;
    }

    public void complete() {
        if(this.state.equals(CoachingState.COMPLETED))
            throw new IllegalStateException("The coaching session is already completed");
        this.state = CoachingState.COMPLETED;
    }

    public void updateDetails(String feedback, String previousNotes) {
        this.feedback = Objects.requireNonNull(feedback, "The feedback is mandatory");
        this.previousNotes = Objects.requireNonNull(previousNotes, "The previous notes are mandatory");
    }
}
