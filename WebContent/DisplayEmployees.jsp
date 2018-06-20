<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align=center bgcolor=green width=50% border=1>
		<tr>
			<td>Employee Id</td>
			<td>Employee Name</td>
			<td>Employee Salary</td>
			<td>Employee Deptno</td>
		</tr>
		<c:forEach var="emp" items="${elist}">
			<tr>
				<td>${emp.empid}</td>
				<td>${emp.ename}</td>
				<td>${emp.salary}</td>
				<td>${emp.deptno}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>