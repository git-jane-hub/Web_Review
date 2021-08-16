package kr.co.abc.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class R07Board_paging_service implements R01Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			int currentPage = 1;
			currentPage = Integer.parseInt(request.getParameter("page"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
