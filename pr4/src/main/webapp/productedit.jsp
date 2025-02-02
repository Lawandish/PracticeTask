<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.example.proj.beans.Product"%>
<%@page import="com.example.proj.dao.PharmacyDao"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
        // Инициализация переменных
        String id = request.getParameter("id");
        String errmsg = "";
        String productname = "";
        String price = "";

        // Проверка наличия параметра "id"
        if (id == null || id.isEmpty()) {
            errmsg = "Invalid parameter!";
        } else {
            // Преобразование "id" в целое число
            int productid = Integer.parseInt(id);

            // Проверка метода HTTP запроса
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                // Получение продукта по "id" и заполнение данных для редактирования
                Product product = PharmacyDao.getProduct(productid);
                productname = product.getProductName();
                price = Double.toString(product.getPrice());
            } else {
                // Получение данных из параметров запроса
                productname = request.getParameter("productname");
                price = request.getParameter("price");

                // Проверка наличия и валидность данных
                if(productname == null || productname.isEmpty()){
                    errmsg = "Product name can't be empty!";
                } else if(price == null || price.isEmpty()){
                    errmsg = "Price can't be empty!";
                }

                double dprice = 0.0;
                if (errmsg.isEmpty()) {
                    try {
                        // Преобразование цены в число
                        dprice = Double.parseDouble(price);
                    } catch (NumberFormatException nfe) {
                        errmsg = "Price must be number!";
                    }
                    // Получение продукта по "id" и обновление данных
                    Product product = PharmacyDao.getProduct(productid);
                    product.setProductName(productname);
                    product.setPrice(dprice);
                    // Обновление продукта
                    PharmacyDao.update(product);
                    // Перенаправление пользователя на страницу со списком продуктов
                    response.sendRedirect("productlist.jsp");
                }
            }
        }

        // Установка атрибутов для передачи данных в JSP
        pageContext.setAttribute("errmsg", errmsg);
        pageContext.setAttribute("
