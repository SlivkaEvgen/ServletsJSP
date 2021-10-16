package org.homework.servlet.company;

import org.homework.controller.interfaces.Controller;
import org.homework.controller.ControllerFactory;
import org.homework.model.BaseModel;
import org.homework.model.Company;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateCompany"})
public class UpdateCompanyServlet<T extends BaseModel<ID>, ID> extends HttpServlet {

    private static final long serialVersionUID = 100000000147L;
    private final Controller<Company, Long> controller = ControllerFactory.of(Company.class);
    private final CrudView<Company, Long> CRUD_VIEW = ViewFactory.of(Company.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.updateGetDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            doGet(req, resp);
        }
        if (Validator.validString(city)) {
            req.setAttribute("error", "wrong city");
            doGet(req, resp);
        }
        Company company = new Company(Long.valueOf(id), name, city);
        controller.update(company);
        CRUD_VIEW.updatePostDo(req, resp);
    }
}
