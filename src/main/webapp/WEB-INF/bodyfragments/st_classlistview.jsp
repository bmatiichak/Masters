<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body >

<div class="container" >

<h2 style="padding: 30px">Class List</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark">
  <thead>
    <tr>
      <th scope="col">Class Name</th>
      <th scope="col">Description</th>     
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.className}</td>
      <td>${li.description}</td>
      <td>      
      <a href="${pageContext.request.contextPath}/classEdit?id=${li.id}">Edit</a>
      <a href="${pageContext.request.contextPath}/classDelete?id=${li.id}">Delete</a>      
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>