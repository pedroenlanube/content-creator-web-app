package dev.pedroenlanube.domain.port.in.strategy;

public interface DomainConsumerStrategy<C> {
    boolean isApplicable(C command);
    void execute(C command);
}
