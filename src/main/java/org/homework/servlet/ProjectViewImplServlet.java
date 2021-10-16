package org.homework.servlet;

import lombok.SneakyThrows;
import org.homework.controller.ProjectControllerImpl;
import org.homework.controller.interfaces.ProjectController;
import org.homework.model.Project;
import org.homework.servlet.interfaces.ProjectView;
import org.homework.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectViewImplServlet extends ModelServletViewServlet<Project, Long> implements ProjectView {

    private static final long serialVersionUID = 16660000066L;
    private final ProjectController controller;

    public ProjectViewImplServlet(Class<Project> classModel) {
        super(classModel);
        controller = new ProjectControllerImpl(Project.class);
    }

    @SneakyThrows
    @Override
    public void projectWithDateGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("projectsWithDate", controller.getListProjectsWithDate());
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/project/projectListWithDateView.jsp")
                .forward(req, resp);
    }

    @Override
    public void updateDoGet(HttpServletRequest req, HttpServletResponse resp) {
        super.updateGetDo(req, resp);
    }

    @Override
    public void updateDoPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String cost = req.getParameter("cost");
        String firstDate = req.getParameter("firstDate");
        String companyId = req.getParameter("companyId");
        String customerId = req.getParameter("customerId");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            updateDoGet(req, resp);
        }
        if (Validator.validString(firstDate)) {
            req.setAttribute("error", "wrong firstDate");
            updateDoGet(req, resp);
        }
        if (!Validator.validNumber(cost)) {
            req.setAttribute("error", "wrong cost");
            updateDoGet(req, resp);
        }
        if (!Validator.validNumber(companyId)) {
            req.setAttribute("error", "wrong companyId");
            updateDoGet(req, resp);
        }
        if (!Validator.validNumber(customerId)) {
            req.setAttribute("error", "wrong customerId");
            updateDoGet(req, resp);
        }
        Project project = new Project(Long.valueOf(id), name, Long.valueOf(cost), firstDate, Long.valueOf(companyId), Long.valueOf(customerId));
        controller.update(project);
        super.updatePostDo(req, resp);
    }
}
