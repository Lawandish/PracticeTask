<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.example.proj.dao.PharmacyDao"%>
<%
    // Инициализация переменных
    String id = request.getParameter("id");
    String errmsg = "";

    // Проверка наличия параметра "id"
    if (id == null || id.isEmpty()) {
        errmsg = "Invalid parameter!";
    } else {
        // Преобразование "id" в целое число
        int productid = Integer.parseInt(id);

        // Проверка существования продукта по "id"
        if (PharmacyDao.exists(productid)) {
            // Удаление продукта
            PharmacyDao.delete(productid);
            // Перенаправление пользователя на страницу со списком продуктов
            response.sendRedirect("productlist.jsp");
        } else {
            errmsg = "No Product found!";
        }
    }

    // Установка атрибутов для передачи данных в JSP
    pageContext.setAttribute("errmsg", errmsg);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pharmacy</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<div>
    <h3>Delete Product</h3>
    <h3 style='color:red'>${errmsg}</h3>
</div>
</body>
</html>
