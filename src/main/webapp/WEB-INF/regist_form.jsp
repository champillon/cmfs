<html>
<head>
	<title>Colour Miles for Smiles: Registration Form.</title>
</head>

<body>
	<div id="title">
		<h2>Colour Miles for Smiles: Registration Form.</h2>
	</div>
	<div id="content">
		<form id="regist_form" action="./RegistServlet" method="POST" enctype="multipart/form-data">
			Title: 
				<input type="radio" name="title" value="mr"> Mr </input>
				<input type="radio" name="title" value="mrs"> Mrs </input>
				<input type="radio" name="title" value="ms"> Ms </input>
			<br/>
			First Name: <input type="text" name="firstName"><br/>
			Last Name: <input type="text" name="lastName"/><br/>
			Date of Birth: <input type="datetime" name="birthDate" /><br/>
			Mobile: <input type="tel" name="mobile" /><br/>
			e-Mail: <input type="email" name="email" /><br/>
			Address: 
				<textarea name="address" rows="4" cols="50" form="regist_form">
				Input address here...
				</textarea>
			<br/>
			T-Shirt Size: 
				<input type="radio" name="tShirtSize" value="s">S - 36" </input>
				<input type="radio" name="tShirtSize" value="m">M - 40" </input>
				<input type="radio" name="tShirtSize" value="l">L - 44" </input>
				<input type="radio" name="tShirtSize" value="xl">XL - 48" </input>
			<br/>
			
<!-- 			<div  style="border-style: solid;border-width: 5px;"> -->
<!-- 			Add more Runner...<br/> -->
<!-- 				Title:  -->
<!-- 					<input type="radio" name="title" value="mr"> Mr </input> -->
<!-- 					<input type="radio" name="title" value="mrs"> Mrs </input> -->
<!-- 					<input type="radio" name="title" value="ms"> Ms </input> -->
<!-- 				<br/> -->
<!-- 				First Name: <input type="text" name="firstName"><br/> -->
<!-- 				Last Name: <input type="text" name="lastName"/><br/> -->
<!-- 				Date of Birth: <input type="datetime" name="birthDate" /><br/> -->
<!-- 				Mobile: <input type="tel" name="mobile" /><br/> -->
<!-- 				e-Mail: <input type="email" name="email" /><br/> -->
<!-- 				T-Shirt Size:  -->
<!-- 					<input type="radio" name="tShirtSize" value="s">S </input> -->
<!-- 					<input type="radio" name="tShirtSize" value="m">M </input> -->
<!-- 					<input type="radio" name="tShirtSize" value="l">L </input> -->
<!-- 					<input type="radio" name="tShirtSize" value="xl">XL </input> -->
<!-- 				<br/> -->
<!-- 			</div> -->

			Total: 3 people, 2400 baht. </br>
			T-Shirt Pick-up Point: 
				<input type="radio" name="tShirtPickUpPoint" value="emQuatier">EmQuatier</input>
				<input type="radio" name="tShirtPickUpPoint" value="event">Event </input>
			<br/>
			Pay-in Slip: <input type="file" name="payInSlip" size="50" /><br/>
			<input type="submit" value="register"/>
		</form>
	</div>
</body>
</html>
