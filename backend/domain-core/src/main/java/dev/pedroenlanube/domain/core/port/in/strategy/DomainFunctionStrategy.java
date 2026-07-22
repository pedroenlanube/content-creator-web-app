package dev.pedroenlanube.domain.core.port.in.strategy;

public interface DomainFunctionStrategy<C, R> {
    boolean isApplicable(C command);
    R execute(C command);
}
