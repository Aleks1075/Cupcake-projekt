package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Admin;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CupcakeFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "createadmin", urlPatterns = {"/createadmin"} )
public class CreateAdmin extends HttpServlet
{

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("admin", null); // invalidating user object in session scope
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int balance = 500;
        String role = "admin";

        try
        {
            Admin admin = UserFacade.createAdmin(username, email, password, balance, role, connectionPool);
            session = request.getSession();
            session.setAttribute("admin", admin); // adding user object to session scope

            List<Top> toppings = CupcakeFacade.getAllToppings(connectionPool);
            request.setAttribute("toppings", toppings);

            List<Bottom> bottoms = CupcakeFacade.getAllBottoms(connectionPool);
            request.setAttribute("bottoms", bottoms);


            request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}

