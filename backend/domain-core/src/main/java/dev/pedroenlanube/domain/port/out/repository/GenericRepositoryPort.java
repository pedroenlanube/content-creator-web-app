package dev.pedroenlanube.domain.port.out.repository;

public interface GenericRepositoryPort<T,ID> {
    void save(T entity);
}
