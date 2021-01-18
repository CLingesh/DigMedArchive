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
			<h6 class="session">Welcome ${session}...</h6>
			<a href="/logout" <%session.invalidate();%>><img class="logo"
				alt="logout" src="/images/logout.png" width="60" height="60"
				data-toggle="tooltip" title="LogOut"></a>
		</div>
	</div>
</header>
<div class=container>
	<div id=containerfluid>
		<br>
		<div class=info>
			<h3 id=display-top>Patient Information</h3>
			<table class=tabletop>
				<tr>
					<th>Name</th>
					<th>:</th>
					<td>${patient.patientName}</td>
					<th>Phone No</th>
					<th>:</th>
					<td>${patient.patientPhNo}</td>
					<th>Registration Id</th>
					<th>:</th>
					<td>${patient.patientRegId}</td>
				</tr>
				<tr>
					<th>Gender</th>
					<th>:</th>
					<td>${patient.patientGender}</td>
					<th>Blood Group</th>
					<th>:</th>
					<td>${patient.patientBlGroup}</td>
					<th>Date Of Birth</th>
					<th>:</th>
					<td>${patient.patientDob}</td>
				</tr>
			</table>
		</div>
		<br>
		<div class=midle>
			<div class="midlehead">
				<h2 id=display>Enter Latest Treatment Details of
					${patient.patientName}</h2>
			</div>
			<div class="button">
				<a href="/back?id=${patient.patientRegId}" class="btn btn-info">Back</a>
			</div>
		</div>
		<div class="treatment-form">
			<div class="treatmentforminside">
				<br>
				<c:if test="${error>0}">
					<h4 style="color: red">Please enter with valid Treatment
						Credentials...!!!</h4>
				</c:if>
				<form:form modelAttribute="treatment"
					action="submittreatment?id=${patient.patientRegId}" method="POST"
					border="1">
					<div class="form-group">
						<form:label path="treatmentDate" for="treatmentDate">Treatment Date :</form:label>
						<form:input id="treatmentDate" name="treatmentDate"
							path="treatmentDate" type="date" pattern="dd/MM/yyyy"
							class="form-control" />
						<form:errors path="treatmentDate" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="doctorName" for="doctorName">Doctor Name :</form:label>
						<form:input id="doctorName" name="doctorName" path="doctorName"
							class="form-control" />
						<form:errors path="doctorName" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="doctorDegree" for="doctorDegree">Doctor Degree :</form:label>
						<form:input id="doctorDegree" name="doctorDegree"
							path="doctorDegree" class="form-control" />
						<form:errors path="doctorDegree" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="consultationName" for="consultationName">Consultation Name :</form:label>
						<form:input id="consultationName" name="consultationName"
							path="consultationName" class="form-control" />
						<form:errors path="consultationName" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="consultantPhNo" for="consultantPhNo">Consultant PhNo :</form:label>
						<form:input id="consultantPhNo" name="consultantPhNo"
							path="consultantPhNo" class="form-control" />
						<form:errors path="consultantPhNo" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="ailmentReason" for="ailmentReason">Ailment Reason :</form:label>
						<form:textarea id="ailmentReason" name="ailmentReason"
							path="ailmentReason" class="form-control" />
						<form:errors path="ailmentReason" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="ailmentName" for="ailmentName">Ailment Name :</form:label>
						<form:textarea id="ailmentName" name="ailmentName"
							path="ailmentName" class="form-control" />
						<form:errors path="ailmentName" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="ailmentDescription" for="ailmentDescription">Ailment Description :</form:label>
						<form:textarea id="ailmentDescription" name="ailmentDescription"
							path="ailmentDescription" class="form-control" />
						<form:errors path="ailmentDescription" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="treatmentDuration" for="treatmentDuration">Treatment Duration :</form:label>
						<form:input id="treatmentDuration" name="treatmentDuration"
							path="treatmentDuration" class="form-control" />
						<form:errors path="treatmentDuration" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="treatmentResult" for="treatmentResult">Treatment Result :</form:label>
						<form:input id="treatmentResult" name="treatmentResult"
							path="treatmentResult" class="form-control" />
						<form:errors path="treatmentResult" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<form:button type="submit" name="treatment"
							class="btn btn-success btn-sm btn-rounded">Submit</form:button>
						<form:button type="reset"
							class="btn btn-warning btn-sm btn-rounded">
							<a href="/addTreatment?id=${patient.patientRegId}">Clear</a>
						</form:button>
					</div>
				</form:form>
				<br>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>