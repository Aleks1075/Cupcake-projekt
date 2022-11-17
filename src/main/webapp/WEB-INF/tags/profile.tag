<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <div class="container"></div>
    <a class="navbar-brand" href="index.jsp">
        <img src="${pageContext.request.contextPath}/images/logo.png" class="img-fluid" alt="Responsive image" width="1500px;"/>
    </a>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link disabled" href="#">${sessionScope.user.email}</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/info">Info</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log ud</a>
                </div>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 400px;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<footer class="text-center text-black" style="background-color: rgba(128, 128, 128, 5%); margin: 25px 50px;">
    <div class="container" style="padding: 20px 0px;">

        <div class="row">
            <div class="col-sm">
                <div>
                    <a href="mailto: olskers@cupcakes.com">Send os en email</a><br/>
                    <a href="tel: 93601903">Ring til os</a>
                </div>
            </div>


            <%--            <div class="col-sm">--%>
            <%--                <img src="${pageContext.request.contextPath}/images/socialemedier/facebook.png"/>--%>


            <%--                <a class="btn btn-outline-dark btn-floating m-1" href="#!" role="button"--%>
            <%--                ><i class="fa fa-facebook"></i--%>
            <%--                ></a>--%>


            <%--                <a class="btn btn-outline-dark btn-floating m-1" href="#!" role="button"--%>
            <%--                ><i class="fa fa-linkedin"></i--%>
            <%--                ></a>--%>
            <%--            </div>--%>

            <div class="col-sm">
                <div>
                    Bornholmsvej<br/>
                    Cvr. 33557711
                </div>
            </div>
        </div>
    </div>
</footer>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>