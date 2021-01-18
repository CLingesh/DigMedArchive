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
		<div class="bg-warning text-white">${warnmessage}</div>
		<div class="bg-success text-white">${message}</div>
		<div class="midle">
			<div class="midlehead">
				<h2 id=display>Treatment History of Patient
					${patient.patientName}</h2>
			</div>
			<div class="button">
				<a href="/addTreatment?id=${patient.patientRegId}"
					class="btn btn-info">Add New Treatment History</a>
			</div>
		</div>
		<div class="tablebottom">
			<table class="table" border="1" style="width: 250%">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Treatment Id</th>
						<th scope="col">Treatment Date</th>
						<th scope="col">Doctor Name</th>
						<th scope="col">Doctor Degree</th>
						<th scope="col">Institution</th>
						<th scope="col">Doctor ContactNo</th>
						<th scope="col">Treatment Reason</th>
						<th scope="col">Diagnosis</th>
						<th scope="col">Treatment Description</th>
						<th scope="col">Duration</th>
						<th scope="col">Result</th>
					</tr>
				</thead>
				<tbody class="tablebody">
					<c:forEach items="${list}" var="t">
						<tr>
							<td scope="row">${t.treatmentId}</td>
							<td>${t.treatmentDate}</td>
							<td>${t.doctorName}</td>
							<td>${t.doctorDegree}</td>
							<td>${t.consultationName}</td>
							<td>${t.consultantPhNo}</td>
							<td>${t.ailmentReason}</td>
							<td>${t.ailmentName}</td>
							<td>${t.ailmentDescription}</td>
							<td>${t.treatmentDuration}</td>
							<td>${t.treatmentResult}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>
<br>
<%@ include file="common/footer.jspf"%>
