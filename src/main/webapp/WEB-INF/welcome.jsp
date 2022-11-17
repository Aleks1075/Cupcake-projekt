<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:profile>
    <jsp:attribute name="header">
         Shopping page
    </jsp:attribute>

    <jsp:attribute name="footer">
        Shopping page
    </jsp:attribute>

    <jsp:body>

        <h1 class="mb-5 text-center">Shopping side</h1>

        <form class="text-center" action="addtocart" method="post">
            <select name="top">
                <c:forEach var="topItem" items="${sessionScope.topList}">
                    <option value="${topItem.id}">${topItem.name} (${topItem.price} kr)</option>
                </c:forEach>
            </select>
            <select name="bottom">
                <c:forEach var="bottomItem" items="${sessionScope.bottomList}">
                    <option value="${bottomItem.id}">${bottomItem.name} (${bottomItem.price} kr)</option>
                </c:forEach>
            </select>
            <select name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <button class="btn btn-primary" name="addToCart">Add to cart</button>
        </form>

        <h3 class="mt-3">Antal linier i kurven: ${requestScope.cartsize}</h3>

        <form method="post">
        <h3 class="mt-3">Indhold i kurv:</h3>
        <table class="table table-striped">
            <thead>
            <th>TopId:</th>
            <th>Name:</th>
            <th>BottomId:</th>
            <th>Name:</th>
            <th>Antal:</th>
            <th>Pris:</th>
            <th></th>
            <th></th>
            <th></th>
            </thead>

            <c:forEach var="item" items="${sessionScope.cart.cupcakeList}">
                <tr>
                    <td>${item.top.id}</td>
                    <td>${item.top.name}</td>
                    <td>${item.bottom.id}</td>
                    <td>${item.bottom.name}</td>
                    <td>${item.quantity}</td>
                    <td>${(item.top.price + item.bottom.price) * item.quantity} kr,-</td>
                    <td> <button formaction="deleteitem" name="top_id" value="${item.top.id}" class="btn btn-danger">Fjern</button></td>
                    <td> <button formaction="removeitem" name="top_id" value="${item.top.id}" class="btn btn-success">-</button></td>
                    <td> <button formaction="additem" name="top_id" value="${item.top.id}" class="btn btn-success">+</button></td>
                </tr>
            </c:forEach>
        </table>
        </form>

        <h3 class="mt-3">Samlet pris: ${sessionScope.cart.totalPrice} kr,-</h3>

        <p class="mt-4"><a class="btn btn-primary" href="order">Udfør bestilling</a></p>

    </jsp:body>

</t:profile>