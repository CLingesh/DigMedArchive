<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/header.jspf"%>
<header>
	<div id=header>
		<div class=headerleft>
			<img class="logo" alt="DigMedArchiveLogo"
				src="/images/medical-logo.jpg" width="60" height="60"
				data-toggle="tooltip" title="DigiMedArchive Logo">
		</div>
		<div class=headermid>
			<h1 class="heading">DigiMedArchive</h1>
		</div>
		<div class=headerright>
			<h2>
				<a href="/"><img class="logo" alt="home" src="/images/home.jpg"
					width="60" height="60" data-toggle="tooltip" title="Home"></a>
			</h2>
		</div>
	</div>
</header>
<div class=container>
	<div id=containermain>
		<div class=container-fluid>
			<div class="login">
				<form:form modelAttribute="login" action="/submitlogin"
					method="POST" class="login-form">
					<h1 id=welcome>Login</h1>
					<c:if test="${error>0}">
						<h6 style="color: red">Invalid Credentials...!!!</h6>
					</c:if>
					<div class="form-group">
						<form:label path="userName">User</form:label>
						<div class="input-container">
							<i class="fa fa-user icon"></i>
							<form:input path="userName" id="userName" name="userName"
								placeholder="PatientName" class="input-field" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="password">Password</form:label>
						<div class="input-container">
							<i class="fa fa-key icon"></i>
							<form:input path="password" id="password" name="password"
								type="password" placeholder="PatientPhNo" class="input-field" />
							<i class="fa fa-eye icon" onmouseover="mouseoverPass();"
								onmouseout="mouseoutPass();"></i>
						</div>
					</div>
					<br>
					<form:button type="submit" name="submit" class="btn btn-success">Login</form:button>
					<form:button type="reset" class="btn btn-warning">
						<a href="/login">Clear</a>
					</form:button>
				</form:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
