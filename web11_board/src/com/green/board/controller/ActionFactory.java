package com.green.board.controller;

import com.green.board.controller.action.Action;
import com.green.board.controller.action.BoardCheckPass;
import com.green.board.controller.action.BoardCheckPassForm;
import com.green.board.controller.action.BoardDelete;
import com.green.board.controller.action.BoardListAction;
import com.green.board.controller.action.BoardUpdateAction;
import com.green.board.controller.action.BoardUpdateForm;
import com.green.board.controller.action.BoardViewAction;
import com.green.board.controller.action.BoardWriteAction;
import com.green.board.controller.action.BoardWriteFormAction;

public class ActionFactory {	// 요청을 기능으로 연결시켜줄 클래스
	private ActionFactory() {}
	
	private static ActionFactory af = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return af;
	}
	
	/////////////////////////////////////////////////////////////////////
	// 전달받은 기능을 수행할 클래스를 연결시켜주는 메서드
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if(command.equals("board_view")) {
			action = new BoardViewAction();
		} else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassForm();
		} else if(command.equals("board_check_pass")) {
			action = new BoardCheckPass();
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateForm();
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if(command.equals("board_delete")) {
			action = new BoardDelete();
		}
		
		return action;
	}

}
