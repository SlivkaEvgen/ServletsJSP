package org.homework.servlet.skill;

import org.homework.controller.ControllerFactory;
import org.homework.model.Skill;
import org.homework.controller.interfaces.Controller;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;
import org.homework.util.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateSkill"})
public class UpdateSkillServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000017L;
    private final Controller<Skill, Long> controller = ControllerFactory.of(Skill.class);
    private final CrudView<Skill, Long> CRUD_VIEW = ViewFactory.of(Skill.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.updateGetDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String activity = req.getParameter("activity");
        String level = req.getParameter("level");

        if (Validator.validString(activity)) {
            req.setAttribute("error", "wrong activity");
            doGet(req, resp);
        }
        if (Validator.validString(level)) {
            req.setAttribute("error", "wrong level");
            doGet(req, resp);
        }
        if (!activity.equalsIgnoreCase("java")
                & !activity.equalsIgnoreCase("js")
                & !activity.equalsIgnoreCase("c+")
                & !activity.equalsIgnoreCase("c#")) {
            req.setAttribute("error", "wrong activity");
            doGet(req, resp);
        }
        if (!level.equalsIgnoreCase("junior")
                & !level.equalsIgnoreCase("middle")
                & !level.equalsIgnoreCase("senior")) {
            req.setAttribute("error", "wrong level");
            doGet(req, resp);
        }
        Skill skill = new Skill(Long.valueOf(id), activity, level);
        controller.update(skill);
        CRUD_VIEW.updatePostDo(req, resp);
    }
}