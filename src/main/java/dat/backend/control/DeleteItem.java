package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteitem", value = "/deleteitem")
public class DeleteItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        int item_id = Integer.parseInt(request.getParameter("top_id"));
        cart.deleteItem(item_id);
        session.setAttribute("cart", cart);

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}
