package kr.co.abc.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.abc.board.model.R01BoardVO;
import kr.co.abc.board.model.R02BoardDAO;

public class R02Board_write_service implements R01Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		R01BoardVO board = new R01BoardVO();
		board.setbContent(request.getParameter("bContent"));
		board.setbTitle(request.getParameter("bTitle"));
		board.setbName(request.getParameter("bName"));
		R02BoardDAO dao = R02BoardDAO.getInstance();
		if(dao.write(board) == 1) {
			
		}
	}

}
