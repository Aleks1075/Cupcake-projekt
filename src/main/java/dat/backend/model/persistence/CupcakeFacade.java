package dat.backend.model.persistence;

import dat.backend.model.entities.*;

import java.util.ArrayList;
import java.util.List;

public class CupcakeFacade
{
    public static Top getTopById(int topId, ConnectionPool connectionPool)
    {
        return CupcakeMapper.getTopById(topId, connectionPool);
    }

    public static Bottom getBottomById(int bottomId, ConnectionPool connectionPool)
    {
        return CupcakeMapper.getBottomById(bottomId, connectionPool);
    }

    public static List<Top> getAllToppings(ConnectionPool connectionPool)
    {
        return CupcakeMapper.getAllToppings(connectionPool);
    }

    public static List<Bottom> getAllBottoms(ConnectionPool connectionPool)
    {
        return CupcakeMapper.getAllBottoms(connectionPool);
    }

    public static int createOrder(User user, ConnectionPool connectionPool)
    {
        return CupcakeMapper.createOrder(user, connectionPool);
    }

    public static void insertOrderLines(int orderId, ShoppingCart cart, ConnectionPool connectionPool)
    {
        CupcakeMapper.insertOrderLines(orderId, cart, connectionPool);
    }

    public static void deleteItem(int item_id, ConnectionPool connectionPool)
    {
        CupcakeMapper.deleteItem(item_id, connectionPool);
    }

    public static void removeOrder(int orderId, ShoppingCart cart, ConnectionPool connectionPool)
    {
        CupcakeMapper.removeOrder(orderId, cart, connectionPool);
    }
}
