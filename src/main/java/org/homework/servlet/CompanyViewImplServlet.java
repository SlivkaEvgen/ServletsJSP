package org.homework.servlet;

import org.homework.controller.ControllerFactory;
import org.homework.controller.interfaces.Controller;
import org.homework.model.Company;
import org.homework.servlet.interfaces.CompanyView;
import org.homework.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyViewImplServlet extends ModelServletViewServlet<Company, Long> implements CompanyView {

    private static final long serialVersionUID = 16660000066L;
    private final Controller<Company, Long> controller;

    public CompanyViewImplServlet(Class<Company> classModel) {
        super(classModel);
        controller = ControllerFactory.of(Company.class);
    }

    @Override
    public void updateDoGet(HttpServletRequest req, HttpServletResponse resp) {
        super.updateGetDo(req, resp);
    }

    @Override
    public void updateDoPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            updateDoGet(req, resp);
        }
        if (Validator.validString(city)) {
            req.setAttribute("error", "wrong city");
            updateDoGet(req, resp);
        }
        Company company = new Company(Long.valueOf(id), name, city);
        controller.update(company);
        super.updatePostDo(req, resp);
    }
}
