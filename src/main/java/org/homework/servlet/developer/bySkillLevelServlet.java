package org.homework.servlet.developer;

import lombok.SneakyThrows;
import org.homework.controller.interfaces.DeveloperController;
import org.homework.controller.DeveloperControllerImpl;
import org.homework.model.Developer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = {"/bySkillLevel"})
public class bySkillLevelServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000032L;
    private final DeveloperController controller = new DeveloperControllerImpl(Developer.class);

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("developerList", controller.getDevelopersByLevel(""));
        req.getRequestDispatcher("/WEB-INF/view/developer/developersBySkillLevel.jsp")
                .forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        List<Developer> developerList = controller.getDevelopersByLevel(req.getParameter("level"));
        if (!developerList.isEmpty()) {
            req.setAttribute("developerList", developerList);
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/developer/developersBySkillLevel.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/bySkillLevel");
        } else {
            req.setAttribute("error", " Not found developers ");
            doGet(req, resp);
        }
    }
}
