package org.homework.servlet;

import org.homework.controller.ControllerFactory;
import org.homework.controller.interfaces.Controller;
import org.homework.model.Skill;
import org.homework.servlet.interfaces.SkillView;
import org.homework.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkillViewImplServlet extends ModelServletViewServlet<Skill, Long> implements SkillView {

    private static final long serialVersionUID = 16660006666L;
    private final Controller<Skill, Long> controller;

    public SkillViewImplServlet(Class<Skill> classModel) {
        super(classModel);
        controller = ControllerFactory.of(Skill.class);
    }

    @Override
    public void updateDoGet(HttpServletRequest req, HttpServletResponse resp) {
        super.updateGetDo(req, resp);
    }

    @Override
    public void updateDoPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String activity = req.getParameter("activity");
        String level = req.getParameter("level");

        if (Validator.validString(activity)) {
            req.setAttribute("error", "wrong activity");
            updateDoGet(req, resp);
        }
        if (Validator.validString(level)) {
            req.setAttribute("error", "wrong level");
            updateDoGet(req, resp);
        }
        if (!activity.equalsIgnoreCase("java")
                & !activity.equalsIgnoreCase("js")
                & !activity.equalsIgnoreCase("c+")
                & !activity.equalsIgnoreCase("c#")) {
            req.setAttribute("error", "wrong activity");
            updateDoGet(req, resp);
        }
        if (!level.equalsIgnoreCase("junior")
                & !level.equalsIgnoreCase("middle")
                & !level.equalsIgnoreCase("senior")) {
            req.setAttribute("error", "wrong level");
            updateDoGet(req, resp);
        }
        Skill skill = new Skill(Long.valueOf(id), activity, level);
        controller.update(skill);
        super.updatePostDo(req, resp);
    }
}
