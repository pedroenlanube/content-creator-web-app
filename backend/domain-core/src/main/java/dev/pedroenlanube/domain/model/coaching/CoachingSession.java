package dev.pedroenlanube.domain.model.coaching;

import dev.pedroenlanube.domain.model.coaching.vo.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachingSession {
    private String id;
    private String creatorId;
    private String subscriberId;
    private TimeSlot slot;
    private CoachingState state;
    private String feedback;

    public CoachingSession(String id, String creatorId, TimeSlot slot) {
        this.id = Objects.requireNonNull(id, "The coaching session ID is mandatory");
        this.creatorId = Objects.requireNonNull(creatorId, "The creator ID is mandatory");
        this.slot = Objects.requireNonNull(slot, "The time slot is mandatory");
        this.state = CoachingState.AVAILABLE;
        this.subscriberId = null;
    }

    public void book(String subscriberId) {
        if(!this.state.equals(CoachingState.AVAILABLE))
            throw new IllegalStateException("The coaching session is not available");
        this.subscriberId = Objects.requireNonNull(subscriberId, "The subscriber ID is mandatory");
        this.state = CoachingState.BOOKED;
    }

    public void cancel() {
        if(this.state.equals(CoachingState.CANCELLED))
            throw new IllegalStateException("The coaching session is already cancelled");
        if(this.state.equals(CoachingState.COMPLETED))
            throw new IllegalStateException("The coaching session is already completed");
        this.subscriberId = null;
        this.state = CoachingState.CANCELLED;
    }
}
