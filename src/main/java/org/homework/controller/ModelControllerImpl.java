package org.homework.controller;

import org.homework.controller.interfaces.Controller;
import org.homework.model.BaseModel;
import org.homework.service.interfaces.Service;
import org.homework.service.ServiceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class ModelControllerImpl<T extends BaseModel<ID>, ID> implements Controller<T, ID>, Serializable {

    private static final long serialVersionUID = 12900000029L;
    private final Service<T, ID> SERVICE;

    public ModelControllerImpl(Class<T> classModel) {
        SERVICE = new ServiceImpl<>(classModel);
    }

    @Override
    public T create(T t) {
        return SERVICE.create(t);
    }

    @Override
    public T update(T t) {
        return SERVICE.update(t);
    }

    @Override
    public void deleteById(ID id) {
        SERVICE.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return SERVICE.findById(id);
    }

    @Override
    public List<T> findAll() {
        return SERVICE.findAll();
    }
}
