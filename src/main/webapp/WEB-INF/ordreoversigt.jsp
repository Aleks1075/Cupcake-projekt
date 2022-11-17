<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:profile>
    <jsp:attribute name="header">
         Shopping page
    </jsp:attribute>

    <jsp:attribute name="footer">
        Ordreoversigt
    </jsp:attribute>

    <jsp:body>

        <h1>Ordreoversigt</h1>

        <h2>Antal linier i kurven: ${requestScope.}</h2>

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
                    </tr>
                </c:forEach>
            </table>
        </form>

        <h3 class="mt-3">Samlet pris: ${sessionScope.cart.totalPrice} kr,-</h3>

        <p class="mt-4"><a class="btn btn-primary" href="WEB-INF/confirmation.jsp">Confirm</a></p>

    </jsp:body>

</t:profile>