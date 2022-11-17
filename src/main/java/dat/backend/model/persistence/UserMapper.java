package dat.backend.model.persistence;

import dat.backend.model.entities.Admin;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper {
    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    user = new User(username, email, password, role, balance);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String username, String email, String password, String role, double balance, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username, email, password, role, balance) values (?,?,?, ?, ?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.setDouble(5, balance);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    user = new User(username, email, password, role, balance);
                } else {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }


    public static Admin createAdmin(String username, String email, String password, int balance, String role, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Admin admin;
        String sql = "insert into user (username, email, password, role, balance) values (?,?,?, ?, ?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.setInt(5, balance);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    admin = new Admin(username, email, password, role, balance);
                } else {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return admin;
    }

    public static Admin adminLogin(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        Admin admin = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    admin = new Admin(username, email, password, role, balance);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return admin;
    }

    public static List<User> getAllUsers(ConnectionPool connectionPool) {
        List<User> customers = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE role = 'customer'";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    double balance = rs.getInt("balance");
                    User user = new User(username, email, password, role, balance);
                    customers.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void changePassword(String password, ConnectionPool connectionPool) {
        String sql = "UPDATE user SET password = ? WHERE username = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, password);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
