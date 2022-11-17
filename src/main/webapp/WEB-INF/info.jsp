<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:profile>
    <jsp:attribute name="header">
         Profil
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <form method="post">
        <h3 class="mt-3 text-center">Profil</h3>
        <table class="table table-striped">
            <thead>
            <th>Username</th>
            <th>Email</th>
            <th>Kodeord</th>
            <th>Balance</th>
            <th>Role</th>
            </thead>

            <c:forEach var="item" items="${requestScope.users}">
                <tr>
                    <td>${item.username}</td>
                    <td>${item.email}</td>
                    <td>${item.password}</td>
                    <td>${item.balance}</td>
                    <td>${item.role}</td>
            </c:forEach>
        </table>
        </form>

    </jsp:body>

</t:profile>

