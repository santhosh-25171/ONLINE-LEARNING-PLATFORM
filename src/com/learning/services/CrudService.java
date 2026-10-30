package com.learning.services;

import com.learning.repository.InMemoryRepository;
import java.util.List;
import java.util.Optional;

public abstract class CrudService<T> {
    private final InMemoryRepository<T> repository;

    protected CrudService(InMemoryRepository<T> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        validate(entity);
        return repository.save(entity);
    }

    protected abstract void validate(T entity);

    public Optional<T> findById(int id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    protected static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    protected static void requireText(String value, String fieldName) {
        require(value != null && !value.trim().isEmpty(), fieldName + " is required");
    }

    protected static void requireNonNegative(double value, String fieldName) {
        require(Double.isFinite(value) && value >= 0, fieldName + " must be non-negative");
    }

    protected static void requireRange(double value, double minimum, double maximum,
                                       String fieldName) {
        require(Double.isFinite(value) && value >= minimum && value <= maximum,
                fieldName + " must be between " + minimum + " and " + maximum);
    }
}
