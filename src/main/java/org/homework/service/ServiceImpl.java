package org.homework.service;

import org.homework.model.BaseModel;
import org.homework.repository.RepositoryFactory;
import org.homework.repository.interfaces.CrudRepository;
import org.homework.service.interfaces.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class ServiceImpl<T extends BaseModel<ID>, ID> implements Serializable, Service<T, ID> {

    private static final long serialVersionUID = 10000000007L;
    private final CrudRepository<T, ID> crudRepository;

    public ServiceImpl(Class<T> modelClass) {
        crudRepository = RepositoryFactory.of(modelClass);
    }

    @Override
    public Optional<T> findById(ID id) {
        return crudRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return crudRepository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        crudRepository.deleteById(id);
    }

    @Override
    public T update(T t) {
        return crudRepository.update(t);
    }

    @Override
    public T create(T t) {
        return crudRepository.create(t);
    }
}
