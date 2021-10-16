package org.homework.servlet.company;

import org.homework.model.Company;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addNewCompany"})
public class AddNewCompanyServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000074L;
    private final CrudView<Company, Long> CRUD_VIEW = ViewFactory.of(Company.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.addNew(req, resp);
    }
}
