package org.homework.repository;

import org.homework.model.BaseModel;
import org.homework.repository.interfaces.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class ModelRepositoryImpl<T extends BaseModel<ID>, ID> implements CrudRepository<T, ID> {

    private final CrudRepository<T, ID> CRUD_REPOSITORY_JDBC;

    public ModelRepositoryImpl(Class<T> classModel) {
        CRUD_REPOSITORY_JDBC = RepositoryFactory.of(classModel);
    }

    @Override
    public T create(T t) {
        return CRUD_REPOSITORY_JDBC.create(t);
    }

    @Override
    public T update(T t) {
        return CRUD_REPOSITORY_JDBC.update(t);
    }

    @Override
    public void deleteById(ID id) {
        CRUD_REPOSITORY_JDBC.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return CRUD_REPOSITORY_JDBC.findById(id);
    }

    @Override
    public List<T> findAll() {
        return CRUD_REPOSITORY_JDBC.findAll();
    }
}
