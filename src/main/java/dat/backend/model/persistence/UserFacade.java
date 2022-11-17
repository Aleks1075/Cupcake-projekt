package dat.backend.model.persistence;

import dat.backend.model.entities.Admin;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String email, String password, String role, double balance, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(username, email, password, role, balance, connectionPool);
    }

    public static Admin createAdmin(String username, String email, String password, int balance, String role, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createAdmin(username, email, password, balance, role, connectionPool);
    }

    public static Admin adminLogin(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.adminLogin(username, password, connectionPool);
    }

    public static List<User> getAllUsers(ConnectionPool connectionPool)
    {
        return UserMapper.getAllUsers(connectionPool);
    }

    public static void changePassword(String password, ConnectionPool connectionPool)
    {
        UserMapper.changePassword(password, connectionPool);
    }
}
