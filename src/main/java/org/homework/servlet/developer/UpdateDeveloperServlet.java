package org.homework.servlet.developer;

import org.homework.controller.interfaces.Controller;
import org.homework.controller.ControllerFactory;
import org.homework.controller.ControllerImpl;
import org.homework.model.Company;
import org.homework.model.Developer;
import org.homework.servlet.CrudView;
import org.homework.servlet.CrudViewImpl;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateDeveloper"})
public class UpdateDeveloperServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000017L;
    private final Controller<Developer, Long> controller = ControllerFactory.of(Developer.class);
    private final CrudView<Developer, Long> updateDoGet = new CrudViewImpl<>(Developer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        updateDoGet.updateGetDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
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
        updateDoGet.updatePostDo(req, resp);
    }
}
