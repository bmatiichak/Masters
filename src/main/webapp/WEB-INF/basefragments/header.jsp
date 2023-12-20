<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-info text-white">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">School Mgt</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<div class="float-left">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/home">Home</a>
					</li>

					<c:if test="${sessionScope.user == null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/registration">SignUp</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/loginView">Login</a></li>
					</c:if>

					<c:if test="${sessionScope.user.userRole == 'Admin'}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Users </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/registration">Add
									User</a> <a class="dropdown-item"
									href="${pageContext.request.contextPath}/userList">User
									List</a>
							</div></li>


						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Class </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/class">Add Class</a> <a
									class="dropdown-item"
									href="${pageContext.request.contextPath}/classList">Class
									List</a>
									<a
									class="dropdown-item"
									href="${pageContext.request.contextPath}/assignClass">Add Student To Class</a>

							</div></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/studentList">Student List</a>
					</li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/facultyList">Faculty List</a>
					</li>
					
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/accountantList">Accountant List</a>
					</li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Subject </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/subject"> Add Subject</a> <a class="dropdown-item"
									href="${pageContext.request.contextPath}/subjectList">Subject List</a>
							</div></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Attendance</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/attendance">
									Add Attendance</a>
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/attendanceList">
									Attendance List</a>	
							</div></li>
							
				    		<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Fee</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/fee">
									Add Fee</a>
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/feeList">
									Fee List</a>	
							</div></li>
							
							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Marksheet</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/marksheet">
									Add Marksheet</a>
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/marksheetList">
									Marksheet List</a>	
							</div></li>

					</c:if>

					<c:if test="${sessionScope.user.userRole == 'Student'}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/facultyList">Faculty List</a>
					</li>
					
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/accountantList">Accountant List</a>
					</li>
					
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Subject </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/subjectList">Subject List</a>
							</div></li>
							
								<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Attendance</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">			
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/attendanceList">
									Attendance List</a>	
							</div></li>
							
									<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Fee</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/feeList">
									Fee List</a>	
							</div></li>
							
							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Marksheet</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/marksheetList">
									Marksheet List</a>	
							</div></li>

					</c:if>
					<c:if test="${sessionScope.user.userRole == 'Accountant'}">
							
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/accountantList">Accountant List</a>
					</li>
						
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Fee</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/fee">
									Add Fee</a>
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/feeList">
									Fee List</a>	
							</div></li>
					
					</c:if>
					<c:if test="${sessionScope.user.userRole == 'Faculty'}">

						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/facultyList">Faculty List</a>
					</li>
					
					<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Subject </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/subject"> Add Subject</a> <a class="dropdown-item"
									href="${pageContext.request.contextPath}/subjectList">Subject List</a>
							</div></li>
							
							
							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Marksheet</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/marksheet">
									Add Marksheet</a>
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/marksheetList">
									Marksheet List</a>	
							</div></li>
							
					
					</c:if>


				</ul>
			</div>
			<div class="float-right" style="margin-left: 300px">
				<ul class="navbar-nav">
					<c:if test="${sessionScope.user != null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/logout">Logout</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/userEdit?id=${sessionScope.user.id}">My
								Profile</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</nav>