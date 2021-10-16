package org.homework.servlet.company;

import org.homework.model.Company;
import org.homework.servlet.CompanyViewImplServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/companyList"})
public class CompanyListServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000016L;
    private final CompanyViewImplServlet companyView = new CompanyViewImplServlet(Company.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        companyView.getAll(req, resp);
    }
}