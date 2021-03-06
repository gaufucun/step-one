<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@page import="teacher.Teacher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<link rel="stylesheet"  type="text/css"  href="./css/add-update.css"/>

<title>修改界面</title>


</head>
<body>
    <div class="wrap">
        <div class="container">
            <h1>修改信息</h1>
            <form action="update" method="post">
            <c:forEach items="${teachers}" var="teacher" varStatus="st">
                <input type="text" name="id" value="${teacher.id }" placeholder="职工号"/>
                <input type="text" name= "username" value="${teacher.name }" placeholder="用户名"/>
                <input type="text" name="sex" value="${teacher.sex }" placeholder="性别"/>
                <input type="text" name= "birthday" value="${teacher.birthday }" placeholder="生日"/>
                <input type="text" name="salary" value="${teacher.salary }" placeholder="薪水"/>
                <input type="text" name= "college" value="${teacher.college }" placeholder="大学"/>
                <input type="text" name="major" value="${teacher.major }" placeholder="专业"/>
               
                <input type="submit"  name ="yes"value="确认修改"/>
                <input type="submit" name="no" value="取消"/>
                </c:forEach>>
                
            </form>
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</body>


</html>