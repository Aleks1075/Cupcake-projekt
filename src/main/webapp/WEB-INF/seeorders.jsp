<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:admin>
    <jsp:attribute name="header">
         Overview
    </jsp:attribute>

    <jsp:attribute name="footer">
        Overview
    </jsp:attribute>

    <jsp:body>

        <h1 class="mt-3 text-center">Kunder og ordrer</h1>

            <table class="table table-striped">
                <thead>
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
                <th>Order ID</th>
                <th>Order date</th>
                <th>Order Line ID</th>
                <th>Amount</th>
                <th>Top ID</th>
                <th>Top name</th>
                <th>Top price</th>
                <th>Bottom ID</th>
                <th>Bottom name</th>
                <th>Bottom price</th>
                </thead>

                <c:forEach var="userAndOrderList" items="${requestScope.userAndOrderList}">
                    <tr>
                        <td>${userAndOrderList.username}</td>
                        <td>${userAndOrderList.email}</td>
                        <td>${userAndOrderList.password}</td>
                        <td>${userAndOrderList.orderId}</td>
                        <td>${userAndOrderList.order_date}</td>
                        <td>${userAndOrderList.order_line_id}</td>
                        <td>${userAndOrderList.amount}</td>
                        <td>${userAndOrderList.top_id}</td>
                        <td>${userAndOrderList.top_name}</td>
                        <td>${userAndOrderList.top_price}</td>
                        <td>${userAndOrderList.bottom_id}</td>
                        <td>${userAndOrderList.bottom_name}</td>
                        <td>${userAndOrderList.bottom_price}</td>
                    </tr>
                </c:forEach>
            </table>

    </jsp:body>

</t:admin>