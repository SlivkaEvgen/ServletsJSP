package org.homework.servlet.skill;

import org.homework.model.Skill;
import org.homework.servlet.SkillViewImplServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/skillList"})
public class SkillListServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000016L;
    private final SkillViewImplServlet skillView = new SkillViewImplServlet(Skill.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        skillView.getAll(req, resp);
    }
}