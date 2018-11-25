<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="teacher.Teacher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>教职工信息管理界面</title>
</head>
<body>
<table align='center' border='1' cellspacing='0' width="800" height="400">
    <tr>
        <td>id</td>
        <td>名字</td>
        <td>性别</td>
        <td>生日</td>
        <td>薪水</td>
        <td>大学</td>
        <td>专业</td>
    </tr>
    <c:forEach items="${teachers}" var="teacher" varStatus="st">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.sex}</td>
            <td>${teacher.birthday}</td>
            <td>${teacher.salary}</td>
            <td>${teacher.college}</td>
            <td>${teacher.major}</td>
            
            <td>
             
            <form action="addOrderItem" method="post">
             
           <a href="update" name="${teacher.name}">修改</a>
           <a href="delete" name="${teacher.name}">删除</a>
           
            </form>
            </td>
 
        </tr>
    </c:forEach>
</table>
</body>
</html>