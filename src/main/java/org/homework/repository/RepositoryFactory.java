package org.homework.repository;

import org.homework.model.BaseModel;
import org.homework.repository.interfaces.CrudRepository;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryFactory<T extends BaseModel<ID>, ID> extends ModelRepositoryImpl<T, ID> implements Serializable {

    private static final long serialVersionUID = 10000000022L;
    private final static Map<String, CrudRepository> REPOSITORIES = new ConcurrentHashMap<>();

    public RepositoryFactory(Class<T> classModel) {
        super(classModel);
    }

    public synchronized static <T extends BaseModel<ID>, R extends CrudRepository<T, ID>, ID> CrudRepository<T, ID> of(Class<T> modelClass) {
        System.out.println("RepositoryFactory");
        final String modelName = modelClass.getName();
        if (!REPOSITORIES.containsKey(modelName)) {
            REPOSITORIES.put(modelName, new CrudRepositoryImpl<>(modelClass));
        }
        return REPOSITORIES.get(modelName);
    }
}
