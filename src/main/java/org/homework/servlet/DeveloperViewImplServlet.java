package org.homework.servlet;

import lombok.SneakyThrows;
import org.homework.controller.ControllerImpl;
import org.homework.controller.DeveloperControllerImpl;
import org.homework.controller.interfaces.DeveloperController;
import org.homework.model.Company;
import org.homework.model.Developer;
import org.homework.model.Project;
import org.homework.servlet.interfaces.DeveloperView;
import org.homework.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeveloperViewImplServlet extends ModelServletViewServlet<Developer, Long> implements DeveloperView {

    private static final long serialVersionUID = 16660000066L;
    private final DeveloperController controller;

    public DeveloperViewImplServlet(Class<Developer> classModel) {
        super(classModel);
        controller = new DeveloperControllerImpl(Developer.class);
    }

    @SneakyThrows
    @Override
    public void getByActivityGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("developerList", controller.getDevelopersByActivity("Java"));
        req.getRequestDispatcher("/WEB-INF/view/developer/developersBySkillActivity.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void getByActivityPost(HttpServletRequest req, HttpServletResponse resp) {
        List<Developer> developerList = controller.getDevelopersByActivity(req.getParameter("activity"));
        if (!developerList.isEmpty()) {
            req.setAttribute("developerList", developerList);
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/developersBySkillActivity.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/bySkillActivity");
        } else {
            req.setAttribute("error", " Not found developers ");
            getByActivityGet(req, resp);
        }
    }

    @SneakyThrows
    @Override
    public void getByLevelGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("developerList", controller.getDevelopersByLevel(""));
        req.getRequestDispatcher("/WEB-INF/view/developer/developersBySkillLevel.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void getByLevelPost(HttpServletRequest req, HttpServletResponse resp) {
        List<Developer> developerList = controller.getDevelopersByLevel(req.getParameter("level"));
        if (!developerList.isEmpty()) {
            req.setAttribute("developerList", developerList);
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/developersBySkillLevel.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/bySkillLevel");
        } else {
            req.setAttribute("error", " Not found developers ");
            getByLevelGet(req, resp);
        }
    }

    @SneakyThrows
    @Override
    public void fromOneProjectGet(HttpServletRequest req, HttpServletResponse resp) {
        Long projectId = 0L;
        req.setAttribute("developerList", controller.getDevelopersFromOneProject(projectId));
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/developersFromOneProject.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void fromOneProjectPost(HttpServletRequest req, HttpServletResponse resp) {
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

    @SneakyThrows
    @Override
    public void sumSalariesGet(HttpServletRequest req, HttpServletResponse resp) {
        Long projectId = 0L;
        req.setAttribute("sumSalary", controller.getSumSalariesDevelopersOfOneProject(projectId));
        req.getRequestDispatcher("/WEB-INF/view/developer/sumSalariesView.jsp").forward(req, resp);
        req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/sumSalariesView.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void sumSalariesPost(HttpServletRequest req, HttpServletResponse resp) {
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

    @SneakyThrows
    @Override
    public void updateDoPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String salary = req.getParameter("salary");
        String companyId = req.getParameter("companyId");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            doGet(req, resp);
        }
        if (!Validator.validNumber(age) | Long.parseLong(age) > 80) {
            req.setAttribute("error", "wrong age");
            doGet(req, resp);
        }
        if (!gender.equalsIgnoreCase("male") & !gender.equalsIgnoreCase("female")) {
            req.setAttribute("error", "wrong gender");
            doGet(req, resp);
        }
        if (Validator.validString(email) | !email.contains("@")) {
            req.setAttribute("error", "wrong email");
            doGet(req, resp);
        }
        if (!Validator.validNumber(salary) | salary.length() > 10) {
            req.setAttribute("error", "wrong salary");
            doGet(req, resp);
        }
        if (!Validator.validNumber(companyId)) {
            req.setAttribute("error", "wrong companyId");
            doGet(req, resp);
        }
        if (!new ControllerImpl<>(Company.class).findById(Long.valueOf(companyId)).isPresent()) {
            req.setAttribute("error", "not found company " + companyId);
            doGet(req, resp);
        }
        Developer developer = new Developer(Long.valueOf(id), name, Long.valueOf(age), gender, email, Long.valueOf(salary), Long.valueOf(companyId));
        controller.update(developer);
        super.updatePostDo(req, resp);
    }
}
