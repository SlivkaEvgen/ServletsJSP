package org.homework.servlet;

import org.homework.controller.ControllerFactory;
import org.homework.controller.interfaces.Controller;
import org.homework.model.Customer;
import org.homework.servlet.interfaces.CustomerView;
import org.homework.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerViewImplServlet extends ModelServletViewServlet<Customer, Long> implements CustomerView {

    private static final long serialVersionUID = 16660000666L;
    private final Controller<Customer, Long> controller;

    public CustomerViewImplServlet(Class<Customer> classModel) {
        super(classModel);
        controller = ControllerFactory.of(Customer.class);
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
        String budget = req.getParameter("budget");

        if (Validator.validString(name)) {
            req.setAttribute("error", "wrong name");
            updateDoGet(req, resp);
        }
        if (Validator.validString(city)) {
            req.setAttribute("error", "wrong city");
            updateDoGet(req, resp);
        }
        if (!Validator.validNumber(budget)) {
            req.setAttribute("error", "wrong budget");
            updateDoGet(req, resp);
        }
        Customer customer = new Customer(Long.valueOf(id), name, city, Long.valueOf(budget));
        controller.update(customer);
        super.updatePostDo(req, resp);
    }
}
