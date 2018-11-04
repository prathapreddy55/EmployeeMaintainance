<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${ listdto ne null}">
		<table bgcolor="tomato" bordercolor="red" border="1">
			<tr>
				<td>Person NO</td>
				<td>Person Name</td>
				<td>Person Phone</td>
				<td>Person Salary</td>
				<td>EDit No</td>
			</tr>
			<c:forEach var="dto" items="${listdto}">
				<tr>
					<td>${dto.e_no}</td>
					<td>${dto.e_name}</td>
					<td>${dto.e_pn}</td>
					<td>${dto.salary}</td>
					<td><a href="emp/${dto.e_no}/.htm">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>
<br>
<br>
<a href="empxcel.htm">Get Excel</a>
<a href="emps.htm">Get Pdf</a>
<a href="home.htm">Home</a>