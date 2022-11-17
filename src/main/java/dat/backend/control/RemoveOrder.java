package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.OrderLines;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "removeorder", value = "/removeorder")
public class RemoveOrder extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        CupcakeFacade.removeOrder(orderId, cart, connectionPool);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    }
}
