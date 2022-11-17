<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:admin>
    <jsp:attribute name="header">
         Kunder
    </jsp:attribute>

    <jsp:attribute name="footer">
        Kunder
    </jsp:attribute>

    <jsp:body>

        <h1 class="mt-3 text-center">Kunder</h1>

        <form action="login" method="post">
        <table class="table table-striped">
            <thead>
            <th>Username</th>
            <th>Email</th>
            <th>Balance</th>
            </thead>

            <c:forEach var="users" items="${requestScope.users}">
                <tr>
                    <td>${users.username}</td>
                    <td>${users.email}</td>
                    <td>${users.balance}</td>
                </tr>
            </c:forEach>
        </table>
        </form>

    </jsp:body>

</t:admin>