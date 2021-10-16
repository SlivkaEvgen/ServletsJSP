package org.homework.servlet.interfaces;

import org.homework.model.Developer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DeveloperView extends ServletView<Developer, Long> {

    void getByActivityGet(HttpServletRequest req, HttpServletResponse resp);

    void getByActivityPost(HttpServletRequest req, HttpServletResponse resp);

    void getByLevelGet(HttpServletRequest req, HttpServletResponse resp);

    void getByLevelPost(HttpServletRequest req, HttpServletResponse resp);

    void fromOneProjectGet(HttpServletRequest req, HttpServletResponse resp);

    void fromOneProjectPost(HttpServletRequest req, HttpServletResponse resp);

    void sumSalariesGet(HttpServletRequest req, HttpServletResponse resp);

    void sumSalariesPost(HttpServletRequest req, HttpServletResponse resp);

    void updateDoPost(HttpServletRequest req, HttpServletResponse resp);
}
