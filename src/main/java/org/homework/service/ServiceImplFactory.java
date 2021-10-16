package org.homework.service;

import org.homework.model.BaseModel;
import org.homework.service.interfaces.Service;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceImplFactory<T extends BaseModel<ID>, ID> extends ModelServiceImpl<T, ID> implements Serializable {

    private static final long serialVersionUID = 10000000013L;
    private final static Map<String, Service> REPOSITORIES = new ConcurrentHashMap<>();

    public ServiceImplFactory(Class<T> classModel) {
        super(classModel);
    }

    public synchronized static <T extends BaseModel<ID>, R extends Service<T, ID>, ID> Service<T, ID> of(Class<T> modelClass) {
        final String modelName = modelClass.getName();
        if (!REPOSITORIES.containsKey(modelName)) {
            REPOSITORIES.put(modelName, new ServiceImpl<>(modelClass));
        }
        return REPOSITORIES.get(modelName);
    }
}
