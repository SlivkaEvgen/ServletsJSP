package org.homework.servlet.interfaces;

import org.homework.model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerView extends ServletView<Customer, Long> {

    void updateDoGet(HttpServletRequest req, HttpServletResponse resp);

    void updateDoPost(HttpServletRequest req, HttpServletResponse resp);
}
