<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditForm</title>
</head>
<body>
	<form:form action="save.htm" method="post" commandName="dto">
		ENO<form:input path="e_no" disabled="true"/><br>
		ENAME<form:input path="e_name"/><br>
		PN<form:input path="e_pn"/><br>
		SALARY<form:input path="salary"/><br>
		<input type="submit" value="Update">
	</form:form>

</body>
</html>