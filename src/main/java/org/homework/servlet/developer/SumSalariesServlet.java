package org.homework.servlet.developer;

import lombok.SneakyThrows;
import org.homework.controller.interfaces.DeveloperController;
import org.homework.controller.DeveloperControllerImpl;
import org.homework.model.Developer;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/sumSalaries"})
public class SumSalariesServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000033L;
    private final DeveloperController controller = new DeveloperControllerImpl(Developer.class);

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        Long projectId = 0L;
        req.setAttribute("sumSalary", controller.getSumSalariesDevelopersOfOneProject(projectId));
        req.getRequestDispatcher("/WEB-INF/view/developer/sumSalariesView.jsp").forward(req,resp);
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/sumSalariesView.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        String projectId = req.getParameter("projectId");
        if (Validator.validNumber(String.valueOf(projectId))) {
            Object sumSalaries = controller.getSumSalariesDevelopersOfOneProject(Long.valueOf(projectId));
            req.setAttribute("sumSalaries", sumSalaries);
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/sumSalariesView.jsp")
                    .forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/sumSalaries");
        } else {
            req.setAttribute("error", " Not found Project ");
            doGet(req, resp);
        }
    }
}
