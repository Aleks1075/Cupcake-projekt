package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderLines
{
    String username;
    String email;
    String password;
    Timestamp order_date;
    int order_line_id;
    String top_name;
    String bottom_name;

    private int orderId;
    private int top_id;
    private int bottom_id;
    private double top_price;
    private double bottom_price;
    private int amount;

    private List<OrderLines> orderLinesList = new ArrayList<>();

    public OrderLines(int orderId, int top_id, int bottom_id, double top_price, double bottom_price, int amount)
    {
        this.orderId = orderId;
        this.top_id = top_id;
        this.bottom_id = bottom_id;
        this.top_price = top_price;
        this.bottom_price = bottom_price;
        this.amount = amount;
    }

    public OrderLines(String username, String email, String password, int order_id, Timestamp order_date, int order_line_id, int amount, int top_id, String top_name, double top_price, int bottom_id, String bottom_name, double bottom_price)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.order_date = order_date;
        this.order_line_id = order_line_id;
        this.top_name = top_name;
        this.bottom_name = bottom_name;
        this.orderId = order_id;
        this.top_id = top_id;
        this.bottom_id = bottom_id;
        this.top_price = top_price;
        this.bottom_price = bottom_price;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public int getOrder_line_id() {
        return order_line_id;
    }

    public void setOrder_line_id(int order_line_id) {
        this.order_line_id = order_line_id;
    }

    public String getTop_name() {
        return top_name;
    }

    public void setTop_name(String top_name) {
        this.top_name = top_name;
    }

    public String getBottom_name() {
        return bottom_name;
    }

    public void setBottom_name(String bottom_name) {
        this.bottom_name = bottom_name;
    }

    public void setOrderLinesList(List<OrderLines> orderLinesList) {
        this.orderLinesList = orderLinesList;
    }

    public void add(OrderLines orderLines)
    {
        orderLinesList.add(orderLines);
    }

    public int getNumberOfOrderLines()
    {
        return orderLinesList.size();
    }

    public List<OrderLines> getOrderLinesList()
    {
        return orderLinesList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTop_id() {
        return top_id;
    }

    public void setTop_id(int top_id) {
        this.top_id = top_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id) {
        this.bottom_id = bottom_id;
    }

    public double getTop_price() {
        return top_price;
    }

    public void setTop_price(double top_price) {
        this.top_price = top_price;
    }

    public double getBottom_price() {
        return bottom_price;
    }

    public void setBottom_price(double bottom_price) {
        this.bottom_price = bottom_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderLines{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", order_date=" + order_date +
                ", order_line_id=" + order_line_id +
                ", top_name='" + top_name + '\'' +
                ", bottom_name='" + bottom_name + '\'' +
                ", orderId=" + orderId +
                ", top_id=" + top_id +
                ", bottom_id=" + bottom_id +
                ", top_price=" + top_price +
                ", bottom_price=" + bottom_price +
                ", amount=" + amount +
                ", orderLinesList=" + orderLinesList +
                '}';
    }
}
