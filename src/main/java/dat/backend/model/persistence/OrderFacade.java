package dat.backend.model.persistence;

import dat.backend.model.entities.OrderLines;

import java.sql.SQLException;
import java.util.List;

public class OrderFacade {
    public static List<OrderLines> getAllOrders(ConnectionPool connectionPool) throws SQLException
    {
        return OrderMapper.getAllOrders(connectionPool);
    }

    public static List<OrderLines> getAllUsersAndOrders(ConnectionPool connectionPool) throws SQLException {
        return OrderMapper.getAllUsersAndOrders(connectionPool);
    }
}
