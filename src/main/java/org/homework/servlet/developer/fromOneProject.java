package org.homework.servlet.developer;

import org.homework.model.Developer;
import org.homework.servlet.DeveloperViewImplServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/fromOneProject"})
public class fromOneProject extends HttpServlet {

    private static final long serialVersionUID = 10000000031L;
    private final DeveloperViewImplServlet developerView = new DeveloperViewImplServlet(Developer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        developerView.fromOneProjectGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        developerView.fromOneProjectPost(req, resp);
    }
}
