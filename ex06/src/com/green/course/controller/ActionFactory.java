package com.green.course.controller;

import com.green.course.controller.Action.Action;
import com.green.course.controller.Action.CourseInfoAction;
import com.green.course.controller.Action.CourseInsertFormAction;
import com.green.course.controller.Action.CourseListAction;

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
		} else if(command.equals("")) {
			
		} else if(command.equals("")) {
			
		} else if(command.equals("")) {
			
		} else if(command.equals("")) {
			
		}
		
		return action;
	}
}
