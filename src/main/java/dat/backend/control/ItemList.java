package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CupcakeFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "itemlist", value = "/itemlist")
public class ItemList extends HttpServlet
{

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<Top> tops = null;
        tops = CupcakeFacade.getAllToppings(connectionPool);
        request.setAttribute("tops", tops);

        List<Bottom> bottoms = null;
        bottoms = CupcakeFacade.getAllBottoms(connectionPool);
        request.setAttribute("bottoms", bottoms);

        request.getRequestDispatcher("WEB-INF/itemlist.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
