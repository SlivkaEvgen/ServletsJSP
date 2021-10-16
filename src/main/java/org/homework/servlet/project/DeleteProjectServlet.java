package org.homework.servlet.project;

import org.homework.model.Project;
import org.homework.servlet.interfaces.ProjectView;
import org.homework.servlet.ProjectViewImplServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteProject"})
public class DeleteProjectServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000015L;
    private final ProjectView projectView = new ProjectViewImplServlet(Project.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        projectView.delete(req, resp);
    }
}