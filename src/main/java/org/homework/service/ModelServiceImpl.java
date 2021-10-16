package org.homework.service;

import org.homework.model.BaseModel;
import org.homework.repository.interfaces.CrudRepository;
import org.homework.service.interfaces.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class ModelServiceImpl<T extends BaseModel<ID>, ID> implements Service<T, ID>, Serializable {

    private static final long serialVersionUID = 2222224651928374654L;
    private final CrudRepository<T, ID> CRUD_REPOSITORY;

    public ModelServiceImpl(Class<T> classModel) {
        CRUD_REPOSITORY = new ServiceImpl<>(classModel);
    }

    @Override
    public T create(T t) {
        return CRUD_REPOSITORY.create(t);
    }

    @Override
    public T update(T t) {
        return CRUD_REPOSITORY.update(t);
    }

    @Override
    public void deleteById(ID id) {
        CRUD_REPOSITORY.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<T> findAll() {
        return CRUD_REPOSITORY.findAll();
    }
}
