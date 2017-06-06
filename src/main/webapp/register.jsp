<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.04.2017
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">
        <%@include file="/css/bootstrap.min.css" %>
        <%@include file="/css/main.css" %>
    </style>
    <script type="text/javascript">
        <%@include file="js/bootstrap.min.js" %>
        <%@include file="js/main.js" %>
    </script>
    <%--<c:set var="root" value="${pageContext.request.contextPath}"/>--%>

    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />--%>
    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />--%>
   <%--<link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" />--%>

    <%--<script src="<%request.getContextPath();%>js/bootstrap.min.js"></script>--%>
    <%--<script src="<%request.getContextPath();%>js/main.js"></script>--%>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="http://www.clubdesign.at/floatlabels.js"></script>

<div class="container">
    <div class="row centered-form">
        <div class="col-sm-2 col-md-4"></div>
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Зарегистрируйтесь бесплатно</h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="/register" >
                        <div class="form-group">
                            <input type="text" name="user_name" id="user_name" class="form-control input-sm floatlabel" placeholder="Ваше имя">
                        </div>
                        <div class="form-group">
                            <input type="text" name="phone_number" id="phone_number" class="form-control input-sm" placeholder="Ваш телефон">
                        </div>
                        <div class="form-group">
                            <input type="text" name="user_address" id="user_address" class="form-control input-sm" placeholder="Ваш адрес">
                        </div>

                        <div class="form-group">
                            <input type="text" name="login" id="login" class="form-control input-sm" placeholder="Логин">
                        </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Пароль">
                                </div>

                           <input type="submit" value="Регистрация" class="btn btn-info btn-block">

                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-2 col-md-4"></div>
    </div>
</div>

</body>
</html>
