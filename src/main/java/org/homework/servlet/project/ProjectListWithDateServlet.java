package org.homework.servlet.project;

import lombok.SneakyThrows;
import org.homework.controller.interfaces.ProjectController;
import org.homework.controller.ProjectControllerImpl;
import org.homework.model.Project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/projectWithDate"})
public class ProjectListWithDateServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000016L;
    private final ProjectController controller = new ProjectControllerImpl(Project.class);

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("projectsWithDate", controller.getListProjectsWithDate());
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/project/projectListWithDateView.jsp")
                .forward(req, resp);
    }
}