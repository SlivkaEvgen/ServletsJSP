package org.homework.servlet;

import org.homework.model.BaseModel;
import org.homework.servlet.interfaces.ServletView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Optional;

public abstract class ModelServletViewServlet<T extends BaseModel<ID>, ID> extends ServletViewImpl<T, ID> implements ServletView<T, ID>, Serializable {

    private static final long serialVersionUID = 16600000066L;

    public ModelServletViewServlet(Class<T> classModel) {
        super(classModel);
    }

    @Override
    public void addNew(HttpServletRequest req, HttpServletResponse resp) {
        super.addNew(req, resp);
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        super.delete(req, resp);
    }

    @Override
    public void getAll(HttpServletRequest req, HttpServletResponse resp) {
        super.getAll(req, resp);
    }

    @Override
    public void updateGetDo(HttpServletRequest req, HttpServletResponse resp) {
        super.updateGetDo(req, resp);
    }

    @Override
    public void updatePostDo(HttpServletRequest req, HttpServletResponse resp) {
        super.updatePostDo(req, resp);
    }

    @Override
    public Optional<T> getById(ID id) {
        return super.getById(id);
    }
}
