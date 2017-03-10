<html>
<head>
<title>Smile Carnival: Application Form.</title>
<meta http-equiv="Content-Language" content="th">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script>
	var num = 1;
	function appendTo() {
		$form = $("#master-form").clone();
		$("#append-form").append($form);
		$form.toggleClass("hide");
		$form.children("input[name=title]").prop("name", "title" + num);
		$form.children("input[name=tShirtSize]").prop("name",
				"tShirtSize" + num);
		$form.children("input[name=tShirtPickUpPoint]").prop("name",
				"tShirtPickUpPoint" + num);
		num++;
	}
</script>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-75255234-1', 'auto');
	ga('send', 'pageview');
</script>
<style>
.hide {
	display: none;
}
</style>
</head>

<body style="color: black; background: #f1ebdc;text-align: center;padding: 10px;width:600px;">
	<div id="title">
	    <h1>
    			Smile Carnival
    	</h1>
		<h2>
			ใบสมัครApplicationForm
		</h2>

	</div>
	<div style="font-size: 14px;width=600px;text-align: left;">
		<b><u>ขั้นตอนการสมัคร</u></b></br>
		1. ค่าสมัครท่านละ 500 บาทในงานท่านจะพบกับกิจกรรมเกมส์หลากหลาย</br>
		อาหาร และเครื่องดื่มฟรีตลอดงาน </br>
		2. กรุณาโอนเงินเข้าบัญชีชื่อมูลนิธิสร้างรอยยิ้ม  ธนาคารกรุงเทพ สาขาเซ็นทรัล </br>
		เอ็มบาสซี่ เลขที่บัญชี <b>009-8-00444-3</b> พร้อมถ่ายรูปหลักฐานการโอนเงินเก็บไว้ </br>
		3. กรุณากรอกแบบฟอร์มการสมัครของแต่ละท่านให้ครบถ้วน พร้อมโหลดหลักฐานการโอนเงิน</br>
		ก่อนกดยืนยันการสมัคร </br>
		4. ท่านจะได้รับอีเมล์ตอบกลับภายใน 2 วันทำการ </br>
		5. นำอีเมล์ยืนยันการสมัครมารับบัตรได้ที่หน้างาน ณ ลานอเนกประสงค์ </br>
		สนามกีฬาแห่งชาติ (ศุภชลาศัย) ในวันที่ 1 เมษายน 2560 ตั้งแต่เวลา 17.00 น. </br>
		6. หากไม่สะดวกกรอกแบบฟอร์มออนไลน์ สามารถดาวน์โหลดใบสมัครได้<a
			href="http://goo.gl/5U9tBj">ที่นี่</a></br>
	    กรอกรายละเอียด แล้วแฟ็ก กลับมาที่ 02-075-2703 หรืออีเมล์ thailand@operationsmile.org<br />
		7. หากมีคำถาม กรุณาติดต่อ 02-075-2700-2 หรืออีเมล์
		thailand@operationsmile.org<br />
		หมายเหตุ: ท่านสามารถสมัครพร้อมกันได้มากสุด 5 ท่าน สำหรับผู้ที่ต้องการสมัครเกิน 5 ท่าน <br />
		กรุณากรอกแบบฟอร์มการสมัคร และโหลดหลักฐานการโอนเงินอีกครั้ง<br />
	</div>
	<br />
	<div style="font-size: 14px;width=600px;text-align: left;">
		<b><u>How to enter Smile Carnival</u></b></br>
		1. Entry fee is 500 Baht per person, which includes fun games, food and drink </br>
		(all proceeds to Operation Smile Thailand) </br>
		2. Please transfer your fee (number of people X THB 500) to “Operation Smile Foundation”,</br>
		 Bangkok Bank, Central Embassy Branch <b>009-8-00444-3</b> </br>
		3. Please fill out the online application form individually and upload a copy of your transfer </br>
		slip before confirming your application. </br>
		4. A confirmation email for the event will be sent to your email address within 2 working days. </br>
		5. Collect your ticket on the event date at the Outdoor Sport Courtyard </br>
		at National Stadium of Thailand on April 1, 2017 from 17.00 hrs. </br>
		6. The off-line application is available <a href="http://goo.gl/5U9tBj">here</a> to download.</br>
		Please fill out all details and fax to 02-075-2703 or email thailand@operationsmile.org<br />
		7. Should you have any questions, please contact 02-075-2700-2 or email to thailand@operationsmile.org<br />
	    Note: There is a maximum 5 applicants per form. For groups more than 5 applicants<br />
	    please fill out more forms and upload the same transfer slip for each form.<br />
	</div>
	<br />
	<div id="content" >
		<div id="master-form" class="hide" style="text-align: left;">
			คำนำหน้า (Title)*:<br /> <input
				type="radio" name="title" value="mr"> นาย/MR <input
				type="radio" name="title" value="mrs"> นาง/MRS <input
				type="radio" name="title" value="ms"> นางสาว/MS <br /> <br />
			ชื่อ ภาษาไทย: <input type="text" name="firstName"><br /> <br />
			นามสกุล ภาษาไทย: <input type="text" name="lastName" /><br /> <br />
			ชื่อ ภาษาอังกฤษ (First Name in English)*: <input type="text"
				name="firstNameEn"><br /> <br /> นามสกุล ภาษาอังกฤษ (Last
			Name in English)*: <input type="text" name="lastNameEn" /><br /> <br />
			วันและเดือนเกิด (Date of Birth): <select name="birthDate">
				<option value="01">1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select>- <select name="birthMonth">
				<option value="01">January</option>
				<option value="02">February</option>
				<option value="03">March</option>
				<option value="04">April</option>
				<option value="05">May</option>
				<option value="06">June</option>
				<option value="07">July</option>
				<option value="08">August</option>
				<option value="09">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December</option>
			</select> <br /> <br /> เบอร์โทรศัพท์มือถือ (Mobile Phone Number)*: <input
				type="tel" name="mobile" maxlenght="10" /><br /> <b>ตัวอย่าง Example: 0812345678 </b><br /> <br />
			อีเมล์ (Email)*: <input type="email" name="email" /><br /> ยืนยัน
			อีเมล์ (Confirm Email)*: <input type="email" name="confirmEmail" /><br />
			<b>ตัวอย่าง Example:
				thailand@operationsmile.org </b><br />
		</div>
		<form id="regist_form" action="./Regist" method="POST"
			enctype="multipart/form-data" style="text-align: left;">
			<div id="append-form">
				<div style="text-align: left;">
					คำนำหน้า (Title)*:<br /> <input
						type="radio" name="title" value="mr"> นาย/MR <input
						type="radio" name="title" value="mrs"> นาง/MRS <input
						type="radio" name="title" value="ms"> นางสาว/MS <br /> <br />
					ชื่อ ภาษาไทย: <input type="text" name="firstName"><br /> <br />
					นามสกุล ภาษาไทย: <input type="text" name="lastName" /><br /> <br />
					ชื่อ ภาษาอังกฤษ (First Name in English)*: <input type="text"
						name="firstNameEn"><br /> <br /> นามสกุล ภาษาอังกฤษ (Last
					Name in English)*: <input type="text" name="lastNameEn" /><br /> <br />
					วันและเดือนเกิด (Date of Birth): <select name="birthDate">
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>- <select name="birthMonth">
						<option value="01">January</option>
						<option value="02">February</option>
						<option value="03">March</option>
						<option value="04">April</option>
						<option value="05">May</option>
						<option value="06">June</option>
						<option value="07">July</option>
						<option value="08">August</option>
						<option value="09">September</option>
						<option value="10">October</option>
						<option value="11">November</option>
						<option value="12">December</option>
					</select> <br /> <br /> เบอร์โทรศัพท์มือถือ (Mobile Phone Number)*: <input
						type="tel" name="mobile" maxlenght="10" /><br /> <b>ตัวอย่าง Example: 0812345678 </b><br /> <br />
					อีเมล์ (Email)*: <input type="email" name="email" /><br /> ยืนยัน
					อีเมล์ (Confirm Email)*: <input type="email" name="confirmEmail" /><br />
					<b>ตัวอย่าง Example:
						thailand@operationsmile.org </b><br />
				</div>
			</div>

			<input type="button" value="เพิ่มชื่อ (Add more applicants)"
				onclick="javascript:appendTo()" /> <br />แนบเอกสารยืนยันการโอนเงินเฉพาะไฟล์ JPEG เท่านั้น
				(Pay-in Slip JPEG only)*:<br> <input type="file" name="payInSlip" size="50" /><br />
			<br />
			<input type="submit" value="สมัคร/APPLY" /> <br />
		</form>
	</div>
</body>
</html>
