<%--
  Created by IntelliJ IDEA.
  User: ilya_
  Date: 07.08.2019
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<fmt:bundle basename="text">
    <head>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title><fmt:message key="title.error"/></title>
    </head>

    <body>


    <div class="error">

        <br><p><h3><fmt:message key="message.error"/></h3><br>

        <div>
            <b><i>${mistake}</i></b>
        </div>

    </div>

    </body>
</fmt:bundle>
</html>
