package org.homework.service.interfaces;

import org.homework.model.BaseModel;
import org.homework.repository.interfaces.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Service<T extends BaseModel<ID>, ID> extends CrudRepository<T, ID> {

    T create(T e);

    T update(T e);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();
}
