package org.homework.controller;

import org.homework.controller.interfaces.Controller;
import org.homework.model.BaseModel;
import org.homework.service.interfaces.Service;
import org.homework.service.ServiceImplFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class ControllerImpl<T extends BaseModel<ID>, ID> implements Serializable, Controller<T, ID> {

    private static final long serialVersionUID = 10000000028L;
    private final Service<T, ID> service;

    public ControllerImpl(Class<T> classModel) {
        service = ServiceImplFactory.of(classModel);
    }

    @Override
    public T create(T e) {
        return service.create(e);
    }

    @Override
    public T update(T e) {
        return service.update(e);
    }

    @Override
    public void deleteById(ID id) {
        service.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return service.findById(id);
    }

    @Override
    public List<T> findAll() {
        return service.findAll();
    }
}
