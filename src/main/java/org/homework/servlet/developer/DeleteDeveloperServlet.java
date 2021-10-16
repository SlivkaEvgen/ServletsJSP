package org.homework.servlet.developer;

import org.homework.model.Developer;
import org.homework.servlet.CrudView;
import org.homework.servlet.CrudViewImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteDeveloper"})
public class DeleteDeveloperServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000015L;
    private final CrudView<Developer, Long> deleteView = new CrudViewImpl<>(Developer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        deleteView.delete(req, resp);
    }
}