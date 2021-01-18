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
				<a href="/login"><img class="logo" alt="login"
					src="/images/login.jpg" width="60" height="60"
					data-toggle="tooltip" title="LogIn"> </a> <a href="/signup"><img
					class="logo" alt="signup" src="/images/signup.jpg" width="60"
					height="60" data-toggle="tooltip" title="SignUp"></a>
			</h2>
		</div>
	</div>
</header>
<div class=container>
	<div id=containermain>
		<div class=containerleft>
			<div class=container-top-login>
				<div class="bg-warning text-white">
					<strong>${warning}</strong>
				</div>
				<div class="bg-success text-white">
					<strong>${success}</strong>
				</div>
				<br>
				<h1 id=welcome>Welcome to DigiMedArchive Application</h1>
			</div>

			<div class=container-bottom>

				<p class=description>
					This application helps in having a digital copy of all the medical
					record attached to some form of identification on a database would
					be very helpful for that person who is seeking medical help and has
					to travel all around the country for his treatment rather than
					carrying all documents with him/her, misplacing them and having no
					record of it at all".<br> <br> DigMedArchive provide
					precise treatment for the patients ailments and helps to identify
					the allergic medicine that can be avoided.
				</p>

			</div>
		</div>
		<div class=containerright></div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>