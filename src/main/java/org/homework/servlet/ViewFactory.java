package org.homework.servlet;

import org.homework.model.BaseModel;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ViewFactory implements Serializable {

    private static final long serialVersionUID = 10000000130L;
    private final static Map<String, CrudView> VIEW_MAP = new ConcurrentHashMap<>();

    public synchronized static <E extends BaseModel<ID>, R extends CrudView<E, ID>, ID> CrudView<E, ID> of(Class<E> modelClass) {
        final String modelName = modelClass.getName();
        if (!VIEW_MAP.containsKey(modelName)) {
            VIEW_MAP.put(modelName, new CrudViewImpl<>(modelClass));
        }
        return VIEW_MAP.get(modelName);
    }
}
