package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.OrderLines;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
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

@WebServlet(name = "seeorders", value = "/seeorders")
public class SeeOrders extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Top> tops = null;
        tops = CupcakeFacade.getAllToppings(connectionPool);
        request.setAttribute("tops", tops);

        List<Bottom> bottoms = null;
        bottoms = CupcakeFacade.getAllBottoms(connectionPool);
        request.setAttribute("bottoms", bottoms);

        List<User> users = null;
        users = UserFacade.getAllUsers(connectionPool);
        request.setAttribute("users", users);

        List<OrderLines> userAndOrderList = null;
        try {
            userAndOrderList = OrderFacade.getAllUsersAndOrders(connectionPool);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("userAndOrderList", userAndOrderList);

        request.getRequestDispatcher("WEB-INF/seeorders.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}