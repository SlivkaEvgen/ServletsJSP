package org.homework.servlet.project;

import org.homework.model.Project;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteProject"})
public class DeleteProjectServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000015L;
    private final CrudView<Project, Long> CRUD_VIEW = ViewFactory.of(Project.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.delete(req, resp);
    }
}