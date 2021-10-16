package org.homework.controller.interfaces;

import org.homework.model.BaseModel;
import org.homework.service.interfaces.Service;

import java.util.List;
import java.util.Optional;

public interface Controller<T extends BaseModel<ID>,ID> extends Service<T,ID> {

    T create(T e);

    T update(T e);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();
}
