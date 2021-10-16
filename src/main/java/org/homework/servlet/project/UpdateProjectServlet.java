package org.homework.servlet.project;

import org.homework.controller.interfaces.Controller;
import org.homework.controller.ControllerFactory;
import org.homework.model.Project;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateProject"})
public class UpdateProjectServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000017L;
    private final Controller<Project, Long> controller = ControllerFactory.of(Project.class);
    private final CrudView<Project, Long> CRUD_VIEW = ViewFactory.of(Project.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.updateGetDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String cost = req.getParameter("cost");
        String firstDate = req.getParameter("firstDate");
        String companyId = req.getParameter("companyId");
        String customerId = req.getParameter("customerId");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            doGet(req, resp);
        }
        if (Validator.validString(firstDate)) {
            req.setAttribute("error", "wrong firstDate");
            doGet(req, resp);
        }
        if (!Validator.validNumber(cost)) {
            req.setAttribute("error", "wrong cost");
            doGet(req, resp);
        }
        if (!Validator.validNumber(companyId)) {
            req.setAttribute("error", "wrong companyId");
            doGet(req, resp);
        }
        if (!Validator.validNumber(customerId)) {
            req.setAttribute("error", "wrong customerId");
            doGet(req, resp);
        }
        Project project = new Project(Long.valueOf(id), name, Long.valueOf(cost), firstDate, Long.valueOf(companyId), Long.valueOf(customerId));
        controller.update(project);
        CRUD_VIEW.updatePostDo(req, resp);
    }
}
