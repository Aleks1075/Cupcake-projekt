package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.OrderLines;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "userlist", value = "/userlist")
public class UserList extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<User> users = null;
        users = UserFacade.getAllUsers(connectionPool);
        request.setAttribute("users", users);

        request.getRequestDispatcher("WEB-INF/seeusers.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
