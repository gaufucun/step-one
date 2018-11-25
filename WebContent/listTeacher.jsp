<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
    <%@page import="teacher.Teacher" %>
<%
	List<Teacher> list = (List<Teacher>)request.getAttribute("teachers");	
	int pageIndex = 1;
	Integer totalPage = Integer.parseInt(request.getAttribute("totalPage")+"");
	Integer pageMegNum = Integer.parseInt(request.getAttribute("pageMegNum")+"");
	if(request.getAttribute("pageIndex")==null){
		pageIndex = 1;
	}else{
		pageIndex = Integer.parseInt(request.getAttribute("pageIndex")+"");
	}
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; utf-8">
<link rel="stylesheet"  type="text/css"  href="./css/show.css"/>
<title>教职工信息管理界面</title>
</head>
<body >
<div class="Title">
    <h1 >教职工信息管理系统</h1>
</div>
<div class="table">
<table align='center' border='1' cellspacing='0'  width="1500">
    <tr class="one">
         
        <td >职工号</td>
        <td >名字</td>
        <td >性别</td>
        <td >生日</td>
        <td >薪水</td>
        <td >大学</td>
        <td >专业</td>
        <td ><a href="add.jsp" >增加</a></td>
    </tr>
     <%for(int i=(pageIndex-1)*pageMegNum;i<pageIndex*pageMegNum&&i<list.size();i++){%>
        <tr height="50" class="two">
        
            <td class="exchange"><%=list.get(i).getId()%></td>
            <td><%=list.get(i).getName()%></td>
            <td class="exchange"><%=list.get(i).getSex()%></td>
            <td><%=list.get(i).getBirthday()%></td>
            <td class="exchange"><%=list.get(i).getSalary()%></td>
            <td><%=list.get(i).getCollege()%></td>
            <td class="exchange"><%=list.get(i).getMajor()%></td>
            
            <td>
             
            <form action="addOrderItem" method="get">
           <a href="lookInfo?name=<%=list.get(i).getId()%>">查看</a>
           <a href="update?name=<%=list.get(i).getId()%>">修改</a>
           <a href="delete?name=<%=list.get(i).getId()%>">删除</a>
           
            </form>
            </td>
 
        </tr>
    <%} %>
    
</table>
</div>
                    <div class="page">
	                    <a  class="footpage" href="./listTeacher?pageIndex=<%=pageIndex%>&pageTurn=up">&emsp;上一页</a>
						<span>&emsp;第<%=pageIndex%>页&emsp;</span>			
						<a href="./listTeacher?pageIndex=<%=pageIndex%>&pageTurn=down">下一页</a>
						<span>&emsp;共<%=totalPage%>页</span>
					</div>
</body>
</html>