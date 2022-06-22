package com.green.course.vo;

public class CourseVO {
	private String id;
	private String name;
	private int credit;
	private String lecturer;
	private int iweek;
	private String week;
	private int start_hour;
	private int end_hour;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public int getIweek() {
		return iweek;
	}
	public void setIweek(int iweek) {
		this.iweek = iweek;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(int week) {
		String sweek = "";
		switch(week) {
			case 1 : sweek = "월";
					break;
			case 2 : sweek = "화";
					break;
			case 3 : sweek = "수";
					break;
			case 4 : sweek = "목";
					break;
			case 5 : sweek = "금";
					break;
			case 6 : sweek = "토";
					break;
		}
		this.week = sweek;
	}
	public int getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(int start_hour) {
		this.start_hour = start_hour;
	}
	public int getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(int end_hour) {
		this.end_hour = end_hour;
	}
}
