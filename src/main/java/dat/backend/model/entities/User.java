package dat.backend.model.entities;

import java.util.Objects;

public class User
{
    private String username;
    private String email;
    private String password;
    private double balance;
    private String role;

    public User(String username, String email, String password, String role, double balance)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }

    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", role='" + role + '\'' +
                '}';
    }
}
