<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Cupcakes
    </jsp:attribute>

    <jsp:attribute name="footer">
        Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <h2 class="text-center">Oversigt over alle toppings og bottoms</h2>

        <h3 class="mt-3">ToppingList</h3>
        <table class="table table-striped">
            <thead>
            <th>Name</th>
            <th>Price</th>
            </thead>

            <c:forEach var="topping" items="${requestScope.tops}">
                <tr>
                    <td>${topping.name}</td>
                    <td>${topping.price}</td>
                </tr>
            </c:forEach>
        </table>

        <h3 class="mt-3">BottomList</h3>
        <table class="table table-striped">
            <thead>
            <th>Name</th>
            <th>Price</th>
            </thead>

            <c:forEach var="bottom" items="${requestScope.bottoms}">
                <tr>
                    <td>${bottom.name}</td>
                    <td>${bottom.price}</td>
                </tr>
            </c:forEach>
        </table>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu. Du kan gøre det her: <a
                    href="${pageContext.request.contextPath}/login.jsp">Log ind</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>