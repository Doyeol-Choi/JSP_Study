package com.green.course.controller;

import com.green.course.controller.Action.Action;
import com.green.course.controller.Action.CourseDeleteAction;
import com.green.course.controller.Action.CourseInfoAction;
import com.green.course.controller.Action.CourseInsertAction;
import com.green.course.controller.Action.CourseInsertFormAction;
import com.green.course.controller.Action.CourseListAction;
import com.green.course.controller.Action.CourseUpdateAction;
import com.green.course.controller.Action.CourseUpdateFormAction;
import com.green.course.controller.Action.LecturerInfoAction;
import com.green.course.controller.Action.LecturerInsertAction;
import com.green.course.controller.Action.LecturerInsertFormAction;
import com.green.course.controller.Action.LecturerListAction;
import com.green.course.controller.Action.LecturerUpdateAction;

public class ActionFactory {
	private ActionFactory() {}
	
	private static ActionFactory af = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("course_list")) {
			action = new CourseListAction();
		} else if(command.equals("course_insert_form")) {
			action = new CourseInsertFormAction();
		} else if(command.equals("course_insert")) {
			action = new CourseInsertAction();
		} else if(command.equals("course_info")) {
			action = new CourseInfoAction();
		} else if(command.equals("course_delete")) {
			action = new CourseDeleteAction();
		} else if(command.equals("course_update_form")) {
			action = new CourseUpdateFormAction();
		} else if(command.equals("course_update")) {
			action = new CourseUpdateAction();
		} else if(command.equals("lecturer_list")) {
			action = new LecturerListAction();
		} else if(command.equals("lecturer_insert_form")) {
			action = new LecturerInsertFormAction();
		} else if(command.equals("lecturer_insert")) {
			action = new LecturerInsertAction();
		} else if(command.equals("lecturer_info")) {
			action = new LecturerInfoAction();
		} else if(command.equals("lecturer_update")) {
			action = new LecturerUpdateAction();
		}
		
		
		return action;
	}
}
