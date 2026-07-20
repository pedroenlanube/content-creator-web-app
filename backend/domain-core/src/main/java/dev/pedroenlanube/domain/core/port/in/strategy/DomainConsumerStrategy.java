package dev.pedroenlanube.domain.core.port.in.strategy;

public interface DomainConsumerStrategy<C> {
    boolean isApplicable(C command);
    void execute(C command);
}
