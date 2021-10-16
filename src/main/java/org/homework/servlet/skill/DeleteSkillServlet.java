package org.homework.servlet.skill;

import org.homework.model.Skill;
import org.homework.servlet.CrudView;
import org.homework.servlet.ViewFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteSkill"})
public class DeleteSkillServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000015L;
    private final CrudView<Skill, Long> CRUD_VIEW = ViewFactory.of(Skill.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CRUD_VIEW.delete(req, resp);
    }
}