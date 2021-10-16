package org.homework.servlet.interfaces;

import org.homework.model.Company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CompanyView extends ServletView<Company, Long> {

    void updateDoGet(HttpServletRequest req, HttpServletResponse resp);

    void updateDoPost(HttpServletRequest req, HttpServletResponse resp);
}
