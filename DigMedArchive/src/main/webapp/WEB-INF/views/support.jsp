<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				data-toggle="tooltip" title="LogOut"> </a>
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
		<h2 class=support>
			Treatment History of Patient ${patient.patientName} are not yet
			Updated to database...<br> Kindly contact support team for
			further clarification...
		</h2>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
