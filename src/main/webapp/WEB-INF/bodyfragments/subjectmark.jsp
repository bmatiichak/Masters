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
<title>Fill Up Marks</title>
</head>
<body >

<div class="container" >

<h2 style="padding: 30px">Fill Up Marks</h2>
<%@include file="businessMessage.jsp" %>
<sf:form method="post" action="${pageContext.request.contextPath}/addMarksheet" modelAttribute="form">

<sf:input type="hidden" id="studentId" class="form-control form-control-lg" path="studentId" value="${studentId}"/>
<table class="table bg-light text-dark">
  <tbody>
  
  
  <c:forEach items="${subjectList}" var="li" varStatus="u">
    <tr>     
      <td>${li.id}</td>
      <td>${li.subjectName}
      <sf:input type="hidden" id="marks" class="form-control form-control-lg" path="subjectList" value="${li.subjectName}"/>
      </td>      
      <td>
      <s:bind path="marks">
       <sf:input type="text" id="marks" class="form-control form-control-lg" path="marks"/>
      </s:bind>
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
   <div class="mt-4 pt-2">
     <c:if test="${subjectList.size() >0}">
        <input class="btn btn-primary btn-lg" type="submit" value="Add" />
     </c:if>   
   </div>
</sf:form>
</div>

</body>
</html>