<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<link type="text/css" href="./css/style.css" rel="stylesheet">
<script type="text/javascript" src="./jQuery/jquery-3.6.0.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.html" />
		<div id="wrap">
			<h1>투표하기</h1>
			<form action="VoteServlet" method="post">
				<table>
					<tr>
						<th><label for="jumin">주민번호</label></th>
						<td><input type="text" name="jumin" id="jumin" placeholder="'-' 을 제외하고 입력해주세요"> </td>
					</tr>
					<tr>
						<th><label for="name">성명</label></th>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<th>투표번호</th>
						<td>
							<select name="no">
								<option value="" selected>후보선택</option>
								<c:forEach var="Candidate" items="${CandidateList}">
									<option value="${Candidate.no}">[${Candidate.no}] ${Candidate.name}</option>
								</c:forEach>
								<!-- 후보테이블의 기본키면서 유권자테이블의 외래키인 m_no데이터를 value값으로 지정 -->
							</select>
						</td>
					</tr>
					<tr>
						<th><label for="time">투표시간</label></th>
						<td><input type="text" name="time" id="time" placeholder="ex) 9시 30분 0930, 13시 30분 1330"></td>
					</tr>
					<tr>
						<th><label for="area">투표장소</label></th>
						<td><input type="text" name="area" id="area" placeholder="ex) 제1투표장"></td>
					</tr>
					<tr>
						<th>유권자 확인</th>
						<td>
							<input type="radio" name="confirm" id="confirm_Y" value="Y"><label for="confirm_Y"> 확인</label> &nbsp;
							<input type="radio" name="confirm" id="confirm_N" value="N"><label for="confirm_N"> 미확인</label> &nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<!-- 두 버튼에 스크립트 함수 적용 -->
							<input type="submit" value="투표하기" onclick="return chk()">&nbsp;&nbsp;
							<input type="reset" value="다시쓰기" onclick="resetbtn()">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="../footer.html" />
	</div>
	<script type="text/javascript">
		// 각 input값이 입력되었는지 확인하는 스크립트 함수
		function chk() {
			if ($('#jumin').val() == '') {
				alert("주민번호가 입력되지 않았습니다!");
				return false;
			}
			if ($('#name').val() == '') {
				alert("성명이 입력되지 않았습니다!");
				return false;
			}
			if ($('select[name="no"]').val() == '') {
				alert("후보번호가 선택되지 않았습니다!");
				return false;
			}
			if ($('#time').val() == '') {
				alert("투표시간이 입력되지 않았습니다!");
				return false;
			}
			if ($('#area').val() == '') {
				alert("투표장소가 입력되지 않았습니다!");
				return false;
			}
			// confirm이란 이름의 타입이 radio인 input이 체크 되었는지를 확인 
			if ($('input:radio[name="confirm"]').is(":checked") == false) {
				alert("유권자 확인이 선택되지 않았습니다!");
				return false;
			}
			return true;	
		}
		// 입력했던 정보를 지우고 주민등록번호로 커서를 옮기기 위한 스크립트 함수
		function resetbtn() {
			alert("정보를 지우고 처음부터 다시 입력합니다.");
			$('#jumin').focus();
		}
	</script>
</body>
</html>