package org.homework.servlet.interfaces;

import org.homework.model.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProjectView extends ServletView<Project,Long> {

    void projectWithDateGet(HttpServletRequest req, HttpServletResponse resp);

    void updateDoGet(HttpServletRequest req, HttpServletResponse resp);

    void updateDoPost(HttpServletRequest req, HttpServletResponse resp);
}
