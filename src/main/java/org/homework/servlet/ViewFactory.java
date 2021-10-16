package org.homework.servlet;

import org.homework.model.BaseModel;
import org.homework.servlet.interfaces.ServletView;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ViewFactory<T extends BaseModel<ID>, ID> extends ModelServletViewServlet<T, ID> implements Serializable {

    private static final long serialVersionUID = 10000000130L;
    private final static Map<String, ServletView> VIEW_MAP = new ConcurrentHashMap<>();

    public ViewFactory(Class<T> classModel) {
        super(classModel);
    }

    public synchronized static <E extends BaseModel<ID>, R extends ServletView<E, ID>, ID> ServletView<E, ID> of(Class<E> modelClass) {
        final String modelName = modelClass.getName();
        if (!VIEW_MAP.containsKey(modelName)) {
            VIEW_MAP.put(modelName, new ServletViewImpl<>(modelClass));
        }
        return VIEW_MAP.get(modelName);
    }
}
