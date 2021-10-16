package org.homework.servlet.customer;

import org.homework.model.Customer;
import org.homework.servlet.CustomerViewImplServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/customerList"})
public class CustomerListServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000016L;
    private final CustomerViewImplServlet customerView = new CustomerViewImplServlet(Customer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        customerView.getAll(req, resp);
    }
}