<%--
  Created by IntelliJ IDEA.
  User: ilya_
  Date: 07.08.2019
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<fmt:bundle basename="text">
    <head>
        <title><fmt:message key="title.table"/></title>
        <link rel="stylesheet" href="css/style.css" type="text/css">

        <style>
            button.button-back {
                background: -moz-linear-gradient(#00BBD6, #EBFFFF);
                background: -webkit-gradient(linear, 0 0, 0 100%, from(#00BBD6), to(#EBFFFF));
                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00BBD6', endColorstr='#EBFFFF');
                padding: 3px 7px;
                color: black;
                -moz-border-radius: 5px;
                -webkit-border-radius: 5px;
                border-radius: 5px;
                border: 1px solid #666;
                font-size: 15px;
            }
        </style>

    </head>

    <body>



    <div class="table-background">

        <h1 class="page-heading"><fmt:message key="table.pageHead"/></h1><br>

        <h2>
            <button class="button-back"
                    onclick=window.history.back()>
                <fmt:message key="ui_setting.back"/>
            </button>

        </h2>


        <h4>

            <table align="center" border="5" cellpadding="6" cellspacing="0">
                <tr>
                    <th rowspan="2">ID</th>
                    <th rowspan="2"><fmt:message key="table.type"/></th>
                    <th rowspan="2"><fmt:message key="table.country"/></th>
                    <th rowspan="2"><fmt:message key="table.transport"/></th>
                    <th rowspan="2"><fmt:message key="table.transportPrice"/></th>
                    <th rowspan="2"><fmt:message key="table.numberDays"/></th>
                    <th rowspan="2"><fmt:message key="table.departureDate"/></th>
                </tr>

                <tr>
                    <th><fmt:message key="table.hotelLevel"/></th>
                    <th><fmt:message key="table.roomsCount"/></th>
                    <th><fmt:message key="table.foodType"/></th>
                    <th><fmt:message key="table.TVAvailability"/></th>
                    <th><fmt:message key="table.AirConditionAvailability"/></th>
                    <th><fmt:message key="table.hotelPrice"/></th>
                    <th><fmt:message key="table.fullPrice"/></th>
                </tr>

                <c:forEach items="${trip_vouchers}" var="tourist_voucher">
                    <tr>
                        <td> ${tourist_voucher.id} </td>
                        <td> ${tourist_voucher.type}</td>
                        <td> ${tourist_voucher.country} </td>
                        <td> ${tourist_voucher.transport}</td>
                        <td> ${tourist_voucher.tripPrice.transportPrice} </td>
                        <td> ${tourist_voucher.numberDays}</td>
                        <td> ${tourist_voucher.departureDate} </td>

                        <td> ${tourist_voucher.hotelCharacteristic.hotelLevel} </td>
                        <td> ${tourist_voucher.hotelCharacteristic.roomsCount} </td>
                        <td> ${tourist_voucher.hotelCharacteristic.foodType} </td>
                        <td> ${tourist_voucher.hotelCharacteristic.isTVAvailable}</td>
                        <td> ${tourist_voucher.hotelCharacteristic.isAirConditionAvailable} </td>
                        <td> ${tourist_voucher.tripPrice.hotelPrice} </td>
                        <td> ${tourist_voucher.tripPrice.fullPrice} </td>
                    </tr>

                </c:forEach>
            </table>
        </h4>
    </div>
    </body>


</fmt:bundle>
</html>
