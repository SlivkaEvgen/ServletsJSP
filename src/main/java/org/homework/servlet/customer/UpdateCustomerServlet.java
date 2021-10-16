package org.homework.servlet.customer;

import org.homework.controller.interfaces.Controller;
import org.homework.controller.ControllerFactory;
import org.homework.model.Customer;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateCustomer"})
public class UpdateCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000017L;
    private final Controller<Customer, Long> controller = ControllerFactory.of(Customer.class);
    private final CrudView<Customer, Long> CRUD_VIEW = ViewFactory.of(Customer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        CRUD_VIEW.updateGetDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String budget = req.getParameter("budget");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            doGet(req, resp);
        }
        if (Validator.validString(city)) {
            req.setAttribute("error", "wrong city");
            doGet(req, resp);
        }
        if (!Validator.validNumber(budget)) {
            req.setAttribute("error", "wrong budget");
            doGet(req, resp);
        }
        Customer customer = new Customer(Long.valueOf(id), name, city, Long.valueOf(budget));
        controller.update(customer);
        CRUD_VIEW.updatePostDo(req, resp);
    }
}
