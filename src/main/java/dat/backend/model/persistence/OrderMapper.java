package dat.backend.model.persistence;

import dat.backend.model.entities.OrderLines;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static List<OrderLines> getAllOrders(ConnectionPool connectionPool) throws SQLException {
        List<OrderLines> orders = new ArrayList<>();
        String sql = "select * from order_lines";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int top_id = rs.getInt("top_id");
                    int bottom_id = rs.getInt("bottom_id");
                    double top_price = rs.getDouble("top_price");
                    double bottom_price = rs.getDouble("bottom_price");
                    int amount = rs.getInt("amount");
                    OrderLines order = new OrderLines(order_id, top_id, bottom_id, top_price, bottom_price, amount);
                    orders.add(order);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return orders;
        }
    }

    public static List<OrderLines> getAllUsersAndOrders(ConnectionPool connectionPool) throws SQLException {
        List<OrderLines> usersAndOrders = new ArrayList<>();
        String sql = "SELECT * FROM user_view";
                try (Connection connection = connectionPool.getConnection())
                {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int order_id = rs.getInt("order_id");
                    Timestamp order_date = rs.getTimestamp("order_date");
                    int order_line_id = rs.getInt("order_line_id");
                    int amount = rs.getInt("amount");
                    int top_id = rs.getInt("top_id");
                    String top_name = rs.getString("top_name");
                    double top_price = rs.getDouble("top_price");
                    int bottom_id = rs.getInt("bottom_id");
                    String bottom_name = rs.getString("bottom_name");
                    double bottom_price = rs.getDouble("bottom_price");
                    OrderLines order = new OrderLines(username, email, password, order_id, order_date, order_line_id, amount, top_id, top_name, top_price, bottom_id, bottom_name, bottom_price);
                    usersAndOrders.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return usersAndOrders;
        }
    }
}

