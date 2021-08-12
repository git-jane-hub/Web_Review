package kr.co.abc.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.abc.user.model.R01UserVO;
import kr.co.abc.user.model.R02UserDAO;

public class R03UserJoinService implements R01UService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String uId = request.getParameter("uId");
			String uPw = request.getParameter("uPw");
			String uName = request.getParameter("uName");
			String uEmail = request.getParameter("uEmail");
			R01UserVO user = new R01UserVO(uId, uPw, uName, uEmail);
			R02UserDAO dao = R02UserDAO.getInstance();
			dao.userJoin(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
