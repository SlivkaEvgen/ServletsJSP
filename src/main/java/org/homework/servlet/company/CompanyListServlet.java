package org.homework.servlet.company;

import lombok.SneakyThrows;
import org.homework.model.Company;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/companyList"})
public class CompanyListServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000016L;
    private final CrudView<Company, Long> CRUD_VIEW = ViewFactory.of(Company.class);

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.getAll(req, resp);
    }
}