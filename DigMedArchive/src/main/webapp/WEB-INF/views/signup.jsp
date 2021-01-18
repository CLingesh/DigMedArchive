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
	<div class="signup">
		<div class="signup-form">
			<form:form modelAttribute="signup" action="submitsignup"
				method="POST">
				<h2 id=welcome>Registration Page</h2>
				<c:if test="${error>0}">
					<h6 style="color: red">Please enter with valid
						Credentials...!!!</h6>
				</c:if>
				<div class="form-row">
					<div class="col-md-4 mb-3 md-form">
						<label for="patientName">Patient Name</label>
						<form:input id="patientName" name="patientName" path="patientName"
							placeholder="Patient Name" class="form-control" />
						<form:errors path="patientName" cssClass="error"
							class="form-control" />
					</div>
					<div class="col-md-4 mb-3 md-form">
						<label for="patientPhNo">Phone No</label>
						<form:input id="patientPhNo" name="patientPhNo" path="patientPhNo"
							type="tel" pattern="[7-9]{1}[0-9]{9}" placeholder="Phone Number"
							class="form-control" />
						<form:errors path="patientPhNo" cssClass="error" />
					</div>
					<div class="col-md-4 mb-3 md-form">
						<label for="patientGender">Gender</label>
						<div class="form-control">
							Male
							<form:radiobutton id="patientGender" name="patientGender"
								path="patientGender" value="Male" />
							Female
							<form:radiobutton id="patientGender" name="patientGender"
								path="patientGender" value="Female" />
							other
							<form:radiobutton id="patientGender" name="patientGender"
								path="patientGender" value="Transgender" />
						</div>
						<form:errors path="patientGender" cssClass="error" />
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6 mb-3 md-form">
						<label for="patientBlGroup">BloodGroup</label>
						<form:input id="patientBlGroup" name="patientBlGroup"
							path="patientBlGroup" placeholder="Patient Blood Group"
							class="form-control" />
						<form:errors path="patientBlGroup" cssClass="error" />
					</div>
					<div class="col-md-3 mb-3 md-form">
						<label for="patientDob">Date of Birth</label>
						<form:input id="patientDob" name="patientDob" path="patientDob"
							type="date" pattern="yyyy-MM-dd" class="form-control" />
						<form:errors path="patientDob" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<div class="form-check pl-0">
						<label class="containercheck" for="invalidCheck"> <input
							type="checkbox" id="invalidCheck" class="checkbox" required><span
							class="checkmark"></span>Agree to terms and conditions
						</label>
					</div>
				</div>
				<form:button type="submit" name="signup"
					class="btn btn-success btn-sm btn-rounded">SignUp</form:button>
				<form:button type="reset" class="btn btn-warning btn-sm btn-rounded">
					<a href="/signup">Clear</a>
				</form:button>
			</form:form>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
