package com.green.ajax;

public class BoardVO {
	private String num;
	private String name;
	private String content;
	private String date;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public static BoardVO dummy1() {
		BoardVO bVo = new BoardVO();
		bVo.setName("하이");
		bVo.setContent("안녕");
		bVo.setDate("2022. 1. 5.");
		
		return bVo;
	}
	public static BoardVO dummy2() {
		BoardVO bVo = new BoardVO();
		bVo.setName("밥 먹었냐?");
		bVo.setContent("밥은 먹고 다니냐?");
		bVo.setDate("2022. 1. 6.");
		
		return bVo;
	}
	public static BoardVO dummy3() {
		BoardVO bVo = new BoardVO();
		bVo.setName("ㅋㅋㅋ");
		bVo.setContent("ㅋㅋㅋㅋㅋ");
		bVo.setDate("2022. 1. 7.");
		
		return bVo;
	}
}
