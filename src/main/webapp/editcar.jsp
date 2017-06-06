<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.04.2017
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
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
    <title>AddCar</title>
</head>
<body>
<% String userLogin = (String) session.getAttribute("userLogin");%>


<div class="container">
    <div class="row centered-form">
        <div class="col-sm-2 col-md-4"></div>
        <div class="col-xs-12 col-md-4 col-sm-12 col-sm-offset-2 col-md-offset-4">



            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"> Dear, ${username}</h3>
                </div>
                <div class="panel-body">
                    <div class="table-title">
                        <h3>Внесите данные по авто</h3>
                    </div>

                    <form method="post" action="/listCars/editcar">

                        <input type="hidden" name ="car_id" value="${car.car_id}"/>
                        <div class="form-group">
                            <label>Телефон водителя</label>
                            <input class="form-control input-sm" type="text" name ="car_phonenumber" placeholder="Введите телефон водителя" value="${car.car_phonenumber}"/>
                        </div>
                        <div class="form-group">
                            <label>Имя водителя</label>
                            <input class="form-control input-sm" type="text" name ="driver_name" placeholder="Введите имя водителя"  value="${car.driver_name}"/>
                        </div>
                        <div class="form-group">
                            <label>Тип автомобиля</label>
                            <select class="form-control input-sm"  name="car_type" size=1 >
                                <option selected="selected">Выберите тип автомобиля</option>
                                <option  value="passengercar" selected>легковой</option>
                                <option  value="truck">грузовой</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Марка автомобиля</label>
                            <select class="form-control input-sm"  name="car_name" size=1 >
                                <option selected="selected">Выберите марку автомобиля</option>
                                <option  value="Lada Priora" selected>Lada Priora</option>
                                <option  value="Lada 2115">Lada 2115</option>
                                <option  value="Merceded benz 200e">Mercedes benz 200e</option>
                                <option  value="BMW x5">BMW x5</option>
                                <option  value="Porsche 911">Porsche 911 GT3</option>
                                <option  value="Bugatti Veron eb16">Bugatti Veron eb16</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Гос номер автомобиля</label>
                            <input class="form-control input-sm" type="text" name ="car_number" placeholder="Введите гос номер авто" value="${car.car_number}"/>
                        </div>
                        <div class="form-group">
                            <label>Цвет автомобиля</label>
                            <select class="form-control input-sm"  name="car_color" size=1 style="background: #009966; color: #FFF;" onChange="this.style.backgroundColor=this.options[this.selectedIndex].style.backgroundColor">
                                <option>Выберите цвет автомобиля</option>
                                <option value="white" style="background: #fff; color: #000;" >Белый</option>
                                <option value="black" style="background: #000; color: #FFF;" >Черный</option>
                                <option value="red" style="background: #f00; color: #FFF;" >Красный</option>
                                <option value="orange" style="background: #ff5400; color: #FFF;">Оранжевый</option>
                                <option value="yellow" style="background: #ffca00; color: #FFF;">Желтый</option>
                                <option value="green" style="background: #0f0; color: #FFF;" selected>Зеленый</option>
                                <option value="skyey" style="background: #00fff5; color: #FFF;">Голубой</option>
                                <option value="blue" style="background: #0600ff; color: #FFF;">Синий</option>
                                <option value="violet" style="background: #fd00ff; color: #FFF;">Фиолетовый</option>
                            </select>
                        </div>
                        <center>
                            <input type="submit" value="Обновить" class="btn btn-info btn-block" />
                        </center>

                    </form>

                </div>
            </div>
        </div>
        <div class="col-sm-2 col-md-4"></div>

    </div>
</div>


</body>
</html>

