package org.homework.servlet.developer;

import lombok.SneakyThrows;
import org.homework.controller.ControllerImpl;
import org.homework.controller.interfaces.DeveloperController;
import org.homework.controller.DeveloperControllerImpl;
import org.homework.model.Developer;
import org.homework.model.Project;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = {"/fromOneProject"})
public class fromOneProject extends HttpServlet {

    private static final long serialVersionUID = 10000000031L;
    private final DeveloperController controller = new DeveloperControllerImpl(Developer.class);

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        Long projectId = 0L;
        req.setAttribute("developerList", controller.getDevelopersFromOneProject(projectId));
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/developersFromOneProject.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ControllerImpl<Project, Long> projectController = new ControllerImpl<>(Project.class);
        String projectId = req.getParameter("id");

        if (Validator.validNumber(projectId)) {
            if (Validator.validNumber(projectId) & projectController.findById(Long.valueOf(projectId)).isPresent()) {

                List<Developer> developerList = controller.getDevelopersFromOneProject(Long.valueOf(req.getParameter("id")));

                req.setAttribute("developerList", developerList);
                req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/developersFromOneProject.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/fromOneProject");
            } else {
                req.setAttribute("error", "not found Project by ID = " + projectId);
                doGet(req, resp);
            }
        } else {
            req.setAttribute("error", "not found Project by ID = " + projectId);
            doGet(req, resp);
        }
    }
}
