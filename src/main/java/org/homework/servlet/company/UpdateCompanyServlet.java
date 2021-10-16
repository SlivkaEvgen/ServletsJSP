package org.homework.servlet.company;

import org.homework.model.BaseModel;
import org.homework.model.Company;
import org.homework.servlet.CompanyViewImplServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateCompany"})
public class UpdateCompanyServlet<T extends BaseModel<ID>, ID> extends HttpServlet {

    private static final long serialVersionUID = 100000000147L;
    private final CompanyViewImplServlet companyView = new CompanyViewImplServlet(Company.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        companyView.updateDoGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        companyView.updateDoPost(req, resp);
    }
}
