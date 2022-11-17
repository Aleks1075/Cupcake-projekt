<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:admin>
    <jsp:attribute name="header">
         Admin
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <form method="post">
        <h3 class="mt-3 text-center">Alle ordrer:</h3>
        <table class="table table-striped">
            <thead>
            <th>OrderId:</th>
            <th>TopId</th>
            <th>BottomId:</th>
            <th>Antal:</th>
            <th>Samlet pris:</th>
            <th></th>
            </thead>

            <c:forEach var="item" items="${sessionScope.orderList}">
                <tr>
                    <td>${item.orderId}</td>
                    <td>${item.top_id}</td>
                    <td>${item.bottom_id}</td>
                    <td>${item.amount}</td>
                    <td>${(item.top_price + item.bottom_price) * item.amount} kr,-</td>
                    <td><button formaction="removeorder" name="orderId" value="${item.orderId}" class="btn btn-danger">Fjern</button></td>
                </tr>
            </c:forEach>
        </table>
        </form>

        <h2 class="mt-5 text-center">Oversigt over alle toppings og bottoms</h2>

        <h3 class="mt-3">ToppingList</h3>
        <table class="table table-striped">
            <thead>
            <th>TopId:</th>
            <th>Name</th>
            <th>Price</th>
            </thead>

            <c:forEach var="topping" items="${sessionScope.topList}">
                <tr>
                    <td>${topping.id}</td>
                    <td>${topping.name}</td>
                    <td>${topping.price}</td>
                </tr>
            </c:forEach>
        </table>

        <h3 class="mt-3">BottomList</h3>
        <table class="table table-striped">
            <thead>
            <th>BottomId:</th>
            <th>Name</th>
            <th>Price</th>
            </thead>

            <c:forEach var="bottom" items="${sessionScope.bottomList}">
                <tr>
                    <td>${bottom.id}</td>
                    <td>${bottom.name}</td>
                    <td>${bottom.price}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</t:admin>

