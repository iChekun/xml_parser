<%--
  Created by IntelliJ IDEA.
  User: ilya_
  Date: 07.08.2019
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--   for show localization message--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:bundle basename="text">
    <head>

        <title>
            <fmt:message key="title.main"/>
        </title>

        <link rel="stylesheet" href="css/style.css" type="text/css">

    </head>
    <body>

    <form action="mainServlet" method="post" enctype="multipart/form-data">

        <div class="base">

          <br>  <h1 class="page-heading"><fmt:message key="choose.pageHead"/></h1><br>

            <div class="left-column">
                <br><fmt:message key="message.upload_xml"/> <br><br>

                <input type="file" name="xml">

            </div>


            <div class="right-column">

                <br><fmt:message key="message.upload_xsd"/> <br><br>

                <input type="file" name="xsd">

            </div>


            <div class="footer">

                <label>
                    <br><fmt:message key="message.choose_parser"/> <br><br>
                    <input type="radio" checked name="parserName" value="SAX"/>SAX
                    <input type="radio" checked name="parserName" value="DOM"/>DOM
                    <input type="radio" checked name="parserName" value="STAX"/>STAX
                </label>

                <input type="submit" value=<fmt:message key="message.submit"/>/>

            </div>
        </div>
    </form>
    </body>
</fmt:bundle>
</html>
