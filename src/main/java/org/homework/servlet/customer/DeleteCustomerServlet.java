package org.homework.servlet.customer;

import org.homework.model.Customer;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteCustomer"})
public class DeleteCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000015L;
    private final CrudView<Customer, Long> CRUD_VIEW = ViewFactory.of(Customer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        CRUD_VIEW.delete(req, resp);
    }
}