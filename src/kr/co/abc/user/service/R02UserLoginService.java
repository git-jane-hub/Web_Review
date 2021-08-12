package kr.co.abc.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.abc.user.model.R02UserDAO;

public class R02UserLoginService implements R01UService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession session = null;
			session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String uId = request.getParameter("uId");
			String uPw = request.getParameter("uPw");
			R02UserDAO dao = R02UserDAO.getInstance();
			int result = dao.userLogin(uId);
			System.out.println("result 값: " + result);
			if(result == 1) {
				session.setAttribute("login", "success");
				session.setAttribute("id_session", uId);
				session.setAttribute("pw_session", uPw);
			}else if(result == 0) {
				session.setAttribute("login", "failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
