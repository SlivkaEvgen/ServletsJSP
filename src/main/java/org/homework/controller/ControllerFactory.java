package org.homework.controller;

import org.homework.controller.interfaces.Controller;
import org.homework.model.BaseModel;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ControllerFactory<T extends BaseModel<ID>, ID> extends ModelControllerImpl<T, ID> implements Serializable {

    private static final long serialVersionUID = 10000000029L;
    private final static Map<String, Controller> CONTROLLER_MAP = new ConcurrentHashMap<>();

    public ControllerFactory(Class<T> classModel) {
        super(classModel);
    }

    public synchronized static <T extends BaseModel<ID>, R extends Controller<T, ID>, ID> Controller<T, ID> of(Class<T> modelClass) {
        System.out.println("ControllerFactory");
        final String modelName = modelClass.getName();
        if (!CONTROLLER_MAP.containsKey(modelName)) {
            CONTROLLER_MAP.put(modelName, new ControllerImpl<>(modelClass));
        }
        return CONTROLLER_MAP.get(modelName);
    }
}
