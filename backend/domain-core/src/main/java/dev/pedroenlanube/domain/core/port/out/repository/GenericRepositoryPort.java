package dev.pedroenlanube.domain.core.port.out.repository;

public interface GenericRepositoryPort<T,ID> {
    void save(T entity);
}
