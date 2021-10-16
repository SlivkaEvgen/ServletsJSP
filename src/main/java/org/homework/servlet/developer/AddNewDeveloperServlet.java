package org.homework.servlet.developer;

import org.homework.model.Developer;
import org.homework.servlet.CrudView;
import org.homework.servlet.CrudViewImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addNewDeveloper"})
public class AddNewDeveloperServlet extends HttpServlet {

    private static final long serialVersionUID = 10000000074L;
    private final CrudView<Developer, Long> addViewImpl = new CrudViewImpl<>(Developer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        addViewImpl.addNew(req, resp);
    }
}
