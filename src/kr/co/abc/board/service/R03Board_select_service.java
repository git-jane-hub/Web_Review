package kr.co.abc.board.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.abc.board.model.R01BoardVO;
import kr.co.abc.board.model.R02BoardDAO;

public class R03Board_select_service implements R01Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		R02BoardDAO dao = R02BoardDAO.getInstance();
		List<R01BoardVO> boardList = new ArrayList<>(dao.boardSelect());
		request.setAttribute("boardList", boardList);
	}
}
