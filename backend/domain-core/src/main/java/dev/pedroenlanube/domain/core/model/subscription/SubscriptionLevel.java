package dev.pedroenlanube.domain.core.model.subscription;

import dev.pedroenlanube.domain.core.model.subscription.vo.Price;
import lombok.Getter;

import java.util.Objects;

@Getter
public class SubscriptionLevel {
    private final String id;
    private final String creatorId;
    private String name;
    private String description;
    private Price monthlyPrice;
    private boolean active;

    public SubscriptionLevel(String id, String creatorId, String name, Price monthlyPrice) {
        this.id = Objects.requireNonNull(id, "The subscription level ID is mandatory");
        this.creatorId = Objects.requireNonNull(creatorId, "The creator ID is mandatory");
        this.monthlyPrice = Objects.requireNonNull(monthlyPrice, "The monthly price is mandatory");
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name is mandatory");
        }
        this.name = name;
        this.description = "";
        this.active = true;
    }

    public void update(String newName, String newDescription) {
        this.name = Objects.requireNonNull(newName, "The name is mandatory");
        this.description = newDescription != null ? newDescription : this.description;
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}
