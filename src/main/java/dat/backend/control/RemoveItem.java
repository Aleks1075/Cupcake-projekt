package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "removeitem", value = "/removeitem")
public class RemoveItem extends HttpServlet {

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
        int item_id = Integer.parseInt(request.getParameter("top_id"));
        cart.removeItem(item_id);
        session.setAttribute("cart", cart);

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}
