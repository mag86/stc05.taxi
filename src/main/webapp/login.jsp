<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
-->
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
    <title>Login</title>
</head>
<body>
<% String greetingnew = (String) session.getAttribute("greeting new user");%>
<% String loginnew = (String) request.getAttribute("loginnew");%>

<div class="container">
    <div class="row centered-form">
        <div class="col-sm-2 col-md-4"></div>
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><%if ((greetingnew!=null)&&(loginnew!=null)){%>
                        <%=greetingnew%>!
                        <%}%>
                        Войдите в свой аккаунт</h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="/login" >
                        <div class="form-group">
                            <input type="text" name="login" id="login" class="form-control input-sm floatlabel" placeholder="Ваше имя">
                        </div>
                        <div class="form-group">
                            <input type="text" name="password" id="password" class="form-control input-sm floatlabel" placeholder="Ваше имя">
                        </div>
                        <input type="submit" value="Вход" class="btn btn-info btn-block">

                    </form>
                    <a href="/register" id="registration">Регистрация</a>
                </div>
            </div>
        </div>
        <div class="col-sm-2 col-md-4"></div>
    </div>
</div>
</body>
</html>
