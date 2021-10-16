package org.homework.servlet.developer;

import org.homework.model.Developer;
import org.homework.servlet.CrudView;
import org.homework.servlet.CrudViewImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/developerList"})
public class DeveloperListServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000016L;
    private final CrudView<Developer, Long> getListView = new CrudViewImpl<>(Developer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        getListView.getAll(req, resp);
    }
}