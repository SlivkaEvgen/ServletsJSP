package org.homework.servlet.interfaces;

import org.homework.model.Skill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SkillView extends ServletView<Skill, Long> {

    void updateDoGet(HttpServletRequest req, HttpServletResponse resp);

    void updateDoPost(HttpServletRequest req, HttpServletResponse resp);
}
