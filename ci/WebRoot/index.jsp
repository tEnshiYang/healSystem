<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="bootstrap.css" />
	
  </head>
  <div class="buttonArea">
  	<a href="./sandian/bmi.jsp" class="btn btn-primary">bmi年龄分布图</a><br>
  <a href="./sandian/shengao.jsp" class="btn btn-danger">身高年龄分布图</a><br>
  <a href="./sandian/tizhong.jsp" class="btn btn-info">体重年龄分布图</a><br>
  <a href="./bing/healRate.jsp" class="btn btn-success">bmi健康率饼图</a><br>
  </div>
  <div class="showArea">

  </div>
  <body>
   
  </body>
</html>
