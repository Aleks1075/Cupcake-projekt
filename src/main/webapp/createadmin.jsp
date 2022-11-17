<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Opret admin bruger
    </jsp:attribute>

    <jsp:body>

        <form action="createadmin" method="post">
            <table>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="username">Brugernavn: </label></td>
                    <td><input class="form-control" type="text" id="username" name="username"
                               placeholder="Indtast din brugernavn"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="password">Email: </label></td>
                    <td><input class="form-control" type="text" id="email" name="email"
                               placeholder="Indtast din email"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="password">Adgangskode: </label></td>
                    <td><input class="form-control" type="password" id="password" name="password"
                               placeholder="Indtast kodeord"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="password1">Gentag adgangskode: </label></td>
                    <td><input class="form-control" type="password" id="password1" name="password1"
                               placeholder="Gentag kodeord"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button class="btn btn-primary" type="submit" value="Login">Opret</button></td>
                </tr>
            </table>
        </form>
        <c:if test="${sessionScope.user == null}">
            <p>Skal du lave en kunde bruger? Du kan gøre det her: <a
                    href="${pageContext.request.contextPath}/createuser.jsp">Lav kunde bruger</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>