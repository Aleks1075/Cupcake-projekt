<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <form action="adminlogin" method="post">
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="username">Brugernavn: </label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="username" name="username"
                           placeholder="Indtast din brugernavn"/>
                </div>
            </div>

            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="password">Password: </label>
                <div class="col-sm-4">
                    <input class="form-control" type="password" id="password" name="password"
                           placeholder="Indtast din kodeord"/>
                </div>
            </div>
            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>

            <c:if test="${not empty param.msg}">
                <p style="font-size: large">${param.msg}</p>
            </c:if>
            <button class="btn btn-primary" type="submit" value="Login">Log ind</button>
        </form>

        <c:if test="${sessionScope.user == null}">
            <p>Har du ikke nogen admin bruger? Du kan gøre det her: <a
                    href="${pageContext.request.contextPath}/createadmin.jsp">Lav ny bruger</a></p>
        </c:if>

    </jsp:body>
</t:pagetemplate>