<html>
<head>
<title>Colour Miles for Smiles: Registration Form.</title>
<meta http-equiv="Content-Language" content="th">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div id="title">
		<h2>Colour Miles for Smiles: Registration Form.</h2>
	</div>
	<div>
		ขั้นตอนการสมัคร </br> 1. ค่าวิ่งท่านละ 800 บาท เด็กอายุต่ำกว่า 5
		ปีสามารถเข้าร่วมงานได้โดยไม่เสียค่าใช้จ่าย </br> 2. กรุณาโอนเงินเข้าบัญชี
		มูลนิธิสร้างรอยยิ้ม ธนาคาร... เลขที่บัญชี xxx-x-xxxxx-x
		พร้อมถ่ายรูปหลักฐานการโอนเงินเก็บไว้ </br> 3.
		กรอกแบบฟอร์มการสมัครให้ครบถ้วน
		พร้อมโหลดหลักฐานการโอนเงินก่อนกดยืนยันการสมัคร </br>
		4.ท่านสามารถเลือกมารับเสื้อวิ่ง และสายรัดข้อมือได้ 2 ที่ คือ 1.
		จุดรับของที่ห้างเอ็มควอเทียร์วันที่ 26 – 27 มีนาคม 2559 หรือ 2.
		รับหน้างานที่สวนลุมพินี วันที่ 9 เมษายน 2559 </br>
		5.ท่านจะได้รับอีเมลตอบกลับพร้อมหมายเลขวิ่ง และข้อควรทราบต่างๆ
	</div>
	<br/>
	<div id="content">
		<form id="regist_form" action="./Regist" method="POST"  enctype="multipart/form-data">
			คำนำหน้า (Title)*: <br/>
				<input type="radio" name="title" value="mr"> Mr/นาย 
				<input type="radio" name="title" value="mrs"> Mrs/นาง 
				<input type="radio" name="title" value="ms"> Ms/นางสาว 
			<br/> 
			ชื่อ (First Name in Thai)*:	<input type="text" name="firstName"><br/>
			นามสกุล (Last Name In Thai)*: <input type="text" name="lastName" /><br/> 
            ชื่อ ภาษาอังกฤษ (First Name English)*:	<input type="text" name="firstNameEn"><br/>
			นามสกุล ภาษาอังกฤษ (Last Name Egnlish)*: <input type="text" name="lastNameEn" /><br/> 
			่วันและเดือนเกิด (Date of Birth):
				<select name="birthDate">
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
				</select>-
				<select name="birthMonth">
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
				</select>
			<br/> 
			เบอร์โทรศัพท์มือถือ (Mobile)*: <input type="tel" name="mobile" maxlenght="10" /><br/>
			<b>ตัวอย่าง Example: 0812345678 </b><br/>
			อีเมล์ (e-Mail)*: <input type="email"	name="email" /><br/>
			<b>ตัวอย่าง Example: thailand@operationsmile.org </b><br/>
			ไซส์เสื้อ (T-Shirt Size)*:<br/> 
				<input type="radio" name="tShirtSize" value="s">S-36" </input>
				<input type="radio" name="tShirtSize" value="m">M-40" </input> 
				<input type="radio" name="tShirtSize" value="l">L-44" </input>
				<input type="radio" name="tShirtSize" value="xl">XL-48" </input> 
			<br/>
			
			สถานที่รับเสื้อ (T-Shirt Pick-up Point)*: <br/>
				<input	type="radio" name="tShirtPickUpPoint" value="QHouse">รับที่ตึก Q-House ลุมพินี วันที่ 26 – 27 มีนาคม 2559 เวลา 10.00 – 17.00 น.</input><br/>
				<input type="radio" name="tShirtPickUpPoint" value="event">รับหน้างานที่สวนลุมพินี วันที่ 9 เมษายน 2559 เวลา 15.30 น.</input><br/>
			<br/> 
			รวม 1 ท่านค่าลงทะเบียน 800 บาท<br/>
			Total: 1 person, 800 baht. </br>
			แนบเอกสารยืนยันการโอนเงิน (Pay-in Slip)*: <input type="file" name="payInSlip" size="50" /><br/>
			<input type="submit" value="register" />
		</form>
	</div>
</body>
</html>
