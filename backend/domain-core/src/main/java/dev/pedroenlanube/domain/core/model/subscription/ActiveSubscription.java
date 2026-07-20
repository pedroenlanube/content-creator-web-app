package dev.pedroenlanube.domain.core.model.subscription;

import lombok.Getter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Getter
public class ActiveSubscription {
    private final String id;
    private final String subscriberId;
    private final String subscriptionLevelId;
    private Instant initDate;
    private Instant endDate;
    private SubscriptionState state;

    public ActiveSubscription(String id, String subscriberId, String subscriptionLevelId) {
        this.id = Objects.requireNonNull(id, "The active subscription ID is mandatory");
        this.subscriberId = Objects.requireNonNull(subscriberId, "The subscriber ID is mandatory");
        this.subscriptionLevelId = Objects.requireNonNull(subscriptionLevelId, "The subscription level ID is mandatory");
        this.initDate = Instant.now();
        this.endDate = this.initDate.plus(30, ChronoUnit.DAYS);
        this.state = SubscriptionState.ACTIVE;
    }

    public void cancel() {
        this.state = SubscriptionState.CANCELLED;
    }

    public void expire() {
        this.state = SubscriptionState.EXPIRED;
    }

    public void extend() {
        this.endDate = this.endDate.plus(30, ChronoUnit.DAYS);
    }

    public void pendingPayment() {
        this.state = SubscriptionState.PENDING_PAYMENT;
    }
}
