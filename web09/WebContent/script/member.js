function loginCheck() {
	// 아이디 입력 여부
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해 주세요!");
		document.frm.userid.focus();
		return false;
	}
		
	// 비밀번호 입력 여부
	if(document.frm.userpwd.value == ""){
		alert("비밀번호를 입력해 주세요!");
		document.frm.userpwd.focus();
		return false;
	}
	
	return true;
}

function joinCheck() {
	// 이름 입력 여부
	if(document.frm.name.value.length == 0){
		alert("이름을 입력해 주세요!");
		document.frm.name.focus();
		return false;
	}
	
	// 아이디 입력 여부
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해 주세요!");
		document.frm.userid.focus();
		return false;
	}
	
	// 암호 입력 여부
	if(document.frm.userpwd.value.length == 0){
		alert("비밀번호를 입력해 주세요!");
		document.frm.userpwd.focus();
		return false;
	}
	
	// 전화번호 입력 여부
	if(document.frm.phone.value.length == 0){
		alert("전화번호를 입력해 주세요!");
		document.frm.phone.focus();
		return false;
	}
	
	// 암호 일치 여부
	if(document.frm.userpwd.value != document.frm.pwdChk.value){
		alert("비밀번호가 일치하지 않습니다.");
		
		document.frm.userpwd.value = "";
		document.frm.pwdChk.value = "";
		
		document.frm.phone.focus();
		return false;
	}
	
	// 아이디 중복체크 여부
	if(document.frm.reid.value.length == 0){
		alert("중복 체크를 하지 않았습니다.");
		document.frm.reid.focus();
		return false;
	}
	
	return true;
}

function idCheck() {
	// 아이디를 입력받아야 함
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해 주세요!");
		document.frm.userid.focus();
		return false;
	}
	
	let url = "ICS?userid="+document.frm.userid.value;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbar=yes, resizeable=no, width=450, height=200");
}

function idCk() {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	
	self.close();
}

function updateCheck() {
	// 암호 입력 여부
	if(document.frm.userpwd.value.length == 0){
		alert("비밀번호를 입력해 주세요!");
		document.frm.userpwd.focus();
		return false;
	}
	
	// 전화번호 입력 여부
	if(document.frm.phone.value.length == 0){
		alert("전화번호를 입력해 주세요!");
		document.frm.phone.focus();
		return false;
	}
	
	// 암호 일치 여부
	if(document.frm.userpwd.value != document.frm.pwdChk.value){
		alert("비밀번호가 일치하지 않습니다.");
		
		document.frm.userpwd.value = "";
		document.frm.pwdChk.value = "";
		
		document.frm.phone.focus();
		return false;
	}
	
	return true;
}