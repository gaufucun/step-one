<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="teacher.Teacher" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<link rel="stylesheet"  type="text/css"  href="./css/add-update.css"/>
<title>新增界面</title>


</head>
<body>
    <div class="wrap">
        <div class="container">
            <h1>新增信息</h1>
            <form action="add" method="post">
                <input type="text" name="id" placeholder="职工号"/>
                <input type="text" name= "username" placeholder="用户名"/>
                <input type="text" name="sex" placeholder="性别"/>
                <input type="text" name= "birthday" placeholder="生日"/>
                <input type="text" name="salary" placeholder="薪水"/>
                <input type="text" name= "college" placeholder="大学"/>
                <input type="text" name="major" placeholder="专业"/>
               
                <input type="submit" name="yes" value="确认增加"/>
                <input type="submit" name="no" value="取消"/>
                
                
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