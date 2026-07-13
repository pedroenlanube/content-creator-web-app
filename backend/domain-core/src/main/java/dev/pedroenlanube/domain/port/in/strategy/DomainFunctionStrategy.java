package dev.pedroenlanube.domain.port.in.strategy;

public interface DomainFunctionStrategy<C, R> {
    boolean isApplicable(C command);
    R execute(C command);
}
