package kr.co.abc.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.abc.board.model.R01BoardVO;
import kr.co.abc.board.model.R02BoardDAO;

public class R04Board_detail_service implements R01Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// get방식을 통해 uri로 전달받은 bId 값을 활용 
		String bId = request.getParameter("bId");
		R02BoardDAO dao = R02BoardDAO.getInstance();
		R01BoardVO board = dao.boardDetail(bId);
		request.setAttribute("board", board);
	}

}
