package org.homework.servlet;

import lombok.SneakyThrows;
import org.homework.controller.interfaces.Controller;
import org.homework.controller.ControllerFactory;
import org.homework.model.BaseModel;
import org.homework.servlet.interfaces.ServletView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Optional;

public class ServletViewImpl<T extends BaseModel<ID>, ID> extends HttpServlet implements ServletView<T, ID> {

    private static final long serialVersionUID = 10000000066L;
    private final Class<T> classModel;
    private final Controller<T, ID> controller;
    private T t;

    public ServletViewImpl(Class<T> classModel) {
        this.classModel = classModel;
        controller = ControllerFactory.of(classModel);
    }

    @Override
    public void addNew(HttpServletRequest req, HttpServletResponse resp) {
        addNewDoGet(req, resp);
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        doGetDelete(req, resp);
    }

    @Override
    public void getAll(HttpServletRequest req, HttpServletResponse resp) {
        doGetList(req, resp);
        doPostList(req, resp);
    }

    @Override
    public void updateGetDo(HttpServletRequest req, HttpServletResponse resp) {
        getDoUpdate(req, resp);
    }

    @Override
    public void updatePostDo(HttpServletRequest req, HttpServletResponse resp) {
        getPostUpdate(req, resp);
    }

    @Override
    public Optional<T> getById(ID id) {
        return controller.findById(id);
    }

    @SneakyThrows
    private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) {
        controller.deleteById((ID) req.getParameter("id"));
        resp.sendRedirect(req.getContextPath() + "/" + classModel.getSimpleName().toLowerCase(Locale.ROOT) + "List");
    }

    @SneakyThrows
    private void doGetList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(classModel.getSimpleName().toLowerCase(Locale.ROOT) + "List", controller.findAll());
        req.getRequestDispatcher("/WEB-INF/view/" + classModel.getSimpleName().toLowerCase(Locale.ROOT)
                        + "/" + classModel.getSimpleName().toLowerCase(Locale.ROOT) + "ListView.jsp")
                .forward(req, resp);
    }

    private void doPostList(HttpServletRequest req, HttpServletResponse resp) {
        doGetList(req, resp);
    }

    @SneakyThrows
    private void addNewDoGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(classModel.getSimpleName().toLowerCase(Locale.ROOT), controller.create(classModel.newInstance()));
        req.getRequestDispatcher("/WEB-INF/view/" + classModel.getSimpleName().toLowerCase(Locale.ROOT)
                        + "/update" + classModel.getSimpleName() + "View.jsp")
                .forward(req, resp);
    }

    private void getDoUpdate(HttpServletRequest req, HttpServletResponse resp) {
        doGetUpdate(req, resp);
    }

    private void getPostUpdate(HttpServletRequest req, HttpServletResponse resp) {
        doPostUpdate(req, resp);
    }

    @SneakyThrows
    private void doGetUpdate(HttpServletRequest req, HttpServletResponse resp) {
        Optional<T> optionalT = getById((ID) req.getParameter("id"));
        if (optionalT.isPresent()) {
            this.t = optionalT.get();
            req.setAttribute(classModel.getSimpleName().toLowerCase(Locale.ROOT) + "", this.t);
            req.getRequestDispatcher("/WEB-INF/view/" + classModel.getSimpleName().toLowerCase(Locale.ROOT) +
                            "/update" + classModel.getSimpleName() + "View.jsp")
                    .forward(req, resp);
        }
    }

    @SneakyThrows
    private void doPostUpdate(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(classModel.getSimpleName().toLowerCase(Locale.ROOT) + "", this.t);
        resp.sendRedirect(req.getContextPath() + "/" + classModel.getSimpleName().toLowerCase(Locale.ROOT) + "List");
    }
}
