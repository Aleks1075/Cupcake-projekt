<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:profile>
    <jsp:attribute name="header">
         Confirmation
    </jsp:attribute>

    <jsp:attribute name="footer">
        Confirmation page
    </jsp:attribute>

    <jsp:body>

        <div class="backgroundcontainer">
            <div class="p-3 mb-2 bg-light text-dark">
                <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
                    <h2>Kvittering</h2>
                    <div class="info" style="font-size: 20px; font-weight: lighter">
                        <body>
                        <h4 class="mt-5">Din ordre er nu bestilt og du kan hente den om en time. Tusind tak for denne gang!</h4>
                        <input class="mt-3 btn btn-primary" type="submit" value="Tilbage til forsiden" onclick="window.location.href='index.jsp'">
                        </body>
                    </div>
                </div>
            </div>
        </div>


<%--        <h1>Kvittering</h1>--%>

<%--        <body>--%>
<%--        <h4>Din ordre er nu bestilt og du kan hente den om en time. Tusind tak for denne gang!</h4>--%>
<%--        <input type="submit" value="Tilbage til shopping siden" onclick="window.location.href='welcome.jsp'">--%>
<%--        </body>--%>
    </jsp:body>

</t:profile>