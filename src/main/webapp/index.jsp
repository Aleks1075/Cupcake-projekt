<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Olsker Cupcakes
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div class="backgroundcontainer">
            <div class="p-3 mb-2 bg-light text-dark">
                <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
                    <h2>Velkommen til Olsker Cupcakes</h2>
                    <div class="info" style="font-size: 20px; font-weight: lighter">
                        <br>
                        <p> Her hos Olsker cupcakes laver vi super lækre cupcakes til en lav pris!</p>
                        <p> De bliver lavet i vores bageri samme dag som de bliver solgt,
                            så man er altid garanteret en dejlig frisk cupcake.</p>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${sessionScope.user == null}">
            <div class="backgroundcontainer">
                <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
                    <div class="info" style="font-size: 20px; font-weight: lighter">
                        <br>
                        <p> Du skal være logget ind for at kunne bestille.</p>
                        <p> Du kan logge ind her: <a href="login.jsp">Log ind</a></p>
                    </div>
                </div>
            </div>
        </c:if>

    </jsp:body>
</t:pagetemplate>
