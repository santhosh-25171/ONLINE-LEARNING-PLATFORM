package com.learning.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.ToIntFunction;

public abstract class InMemoryRepository<T> {
    private final ConcurrentHashMap<Integer, T> entities = new ConcurrentHashMap<Integer, T>();
    private final ToIntFunction<T> idExtractor;

    protected InMemoryRepository(ToIntFunction<T> idExtractor) {
        this.idExtractor = idExtractor;
    }

    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        int id = idExtractor.applyAsInt(entity);
        if (id <= 0) {
            throw new IllegalArgumentException("Entity id must be greater than zero");
        }
        entities.put(id, entity);
        return entity;
    }

    public Optional<T> findById(int id) {
        return Optional.ofNullable(entities.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<T>(entities.values());
    }

    public boolean deleteById(int id) {
        return entities.remove(id) != null;
    }

    public boolean existsById(int id) {
        return entities.containsKey(id);
    }
}
