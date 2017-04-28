<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
-->
<html>
<head>
    <style type="text/css">
        <%@include file="/css/bootstrap.min.css" %>
        <%@include file="/css/main.css" %>
        <%@include file="/css/table.css" %>
    </style>
    <script type="text/javascript">
        <%@include file="js/bootstrap.min.js" %>
        <%@include file="js/main.js" %>
    </script>
    <title>List</title>
</head>
<body>
<% String login = " "+(String) request.getAttribute("login");%>
<% String greeting = (String) request.getAttribute("greeting");%>
<% String info = (String) request.getAttribute("info");%>
<% String newcaradded = (String) session.getAttribute("newcaradded");%>


<div class="container">
    <div class="row centered-form">

        <div class="col-xs-12 col-sm-12 col-md-12 col-sm-offset-2 col-md-offset-4">



            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">  <%=greeting%><%=login%>!
                        <%if ((newcaradded!=null)){%>
                        <%=newcaradded%>!
                        <%}%></h3>
                </div>
                <div class="panel-body">
                    <div class="table-title">
                    <h3><%=info%></h3>
                </div>

                    <form method="get">
                        <input type="button" value="Добавить" onclick="location.href = '<%= request.getContextPath() %>/addcar'">
                    <table class="table-fill">
                        <thead>
                        <tr>
                            <th class="text-left">id</th>
                            <th class="text-left">тел</th>
                            <th>имя водителя</th>
                            <th class="text-left">тип авто</th>
                            <th>марка авто</th>
                            <th class="text-left">госномер</th>
                            <th>цвет</th>
                            <th class="text-left"></th>
                            <th></th>

                        </tr>
                        </thead>
                        <tbody class="table-hover">
                        <c:forEach items="${requestScope.cars}" var="cars">
                            <tr>
                                <td class="text-left"><c:out value="${cars.car_id}"></c:out></td>
                                <td class="text-left"><c:out value="${cars.car_phonenumber}"></c:out></td>
                                <td class="text-left"><c:out value="${cars.driver_name}"></c:out></td>
                                <td class="text-left"><c:out value="${cars.car_type}"></c:out></td>
                                <td class="text-left"><c:out value="${cars.car_name}"></c:out></td>
                                <td class="text-left"><c:out value="${cars.car_number}"></c:out></td>
                                <td class="text-left"><c:out value="${cars.car_color}"></c:out></td>
                                <td><input type="button" value="Редактировать" onclick="location.href = '<%= request.getContextPath() %>/listCars?id=<c:out value="${cars.car_id}" />'"></td>
                                <td><input type="button" name="edit" value="Удалить" onclick="location.href = '/listCars?delete=<c:out value="${cars.car_id}" />'"></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </form>

                </div>
            </div>
        </div>

    </div>
</div>


</body>
</html>
