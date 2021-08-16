package kr.co.abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.abc.board.model.R01BoardVO;
import kr.co.abc.board.service.R01Service;
import kr.co.abc.board.service.R02Board_write_service;
import kr.co.abc.board.service.R03Board_select_service;
import kr.co.abc.board.service.R04Board_detail_service;
import kr.co.abc.board.service.R07Board_paging_service;
import kr.co.abc.user.service.R01UService;
import kr.co.abc.user.service.R02UserLoginService;
import kr.co.abc.user.service.R03UserJoinService;
import kr.co.abc.user.service.R04UserLogout;


/**
 * Servlet implementation class R01PatternServlet
 */
@WebServlet("*.abc")
public class R01PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public R01PatternServlet() {
        super();
        System.out.println("abc 생성");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("abc 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("abc 소멸");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ui = null;
		String uri = request.getRequestURI();
		R01Service sv = null;
		R01UService usv = null; 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		if(uri.equals("/WebReview/reqjoin.abc")) {					// 회원가입 페이지
			System.out.println("회원가입 요청");
			ui = "01-user/R02User_join_form.jsp";
		}else if(uri.equals("/WebReview/userjoin.abc")) {			// 회원가입 완료
			System.out.println("회원가입 완료");
			usv = new R03UserJoinService();
			usv.execute(request, response);
			ui = "01-user/R01User_Login_form.jsp";
		}else if(uri.equals("/WebReview/userlogin.abc")) {			// 로그인
			System.out.println("로그인 요청");
			usv = new R02UserLoginService();
			usv.execute(request, response);
			HttpSession session = null;
			session = request.getSession();
			String loginCheck = (String)session.getAttribute("login");
			System.out.println("loginCheck 값: " + loginCheck);
			if(loginCheck.equals("success")) {
				ui = "/boardselect.abc";
			}else if(loginCheck.equals("failed")) {
				ui = "01-user/R01User_Login_form.jsp";
			}
		}else if(uri.equals("/WebReview/userlogout.abc")) {			// 로그아웃
			System.out.println("로그아웃");
			usv = new R04UserLogout();
			usv.execute(request, response);
			ui = "01-user/R01User_Login_form.jsp";
		}else if(uri.equals("/WebReview/userupdate.abc")) {			// 회원정보 수정
			System.out.println("회원정보 수정");
		}else if(uri.equals("/WebReview/userdelete.abc")) {			// 회원 탈퇴
			System.out.println("회원 탈퇴");		
		}else if(uri.equals("/WebReview/reqboardwrite.abc")) {		// 글 작성 요청
			System.out.println("글작성요청");
			ui = "02-board/R01Board_write_form.jsp";
		}else if(uri.equals("/WebReview/boardwrite.abc")) {			// 글 작성
			System.out.println("글작성");
			sv = new R02Board_write_service();
			sv.execute(request, response);
			ui = "/boardselect.abc";
		}else if(uri.equals("/WebReview/boardselect.abc")) {		// 글 목록 조회
			System.out.println("글목록조회");
//			sv = new R03Board_select_service();
//			sv.execute(request, response);
//			ui = "/02-board/R02Board_list.jsp";
			sv = new R07Board_paging_service();
			sv.execute(request, response);
			ui = "/02-board/R02Board_list.jsp";
		}else if(uri.equals("/WebReview/boarddetail.abc")) {		// 글 내용 조회
			System.out.println("글내용조회");
			sv = new R04Board_detail_service();
			sv.execute(request, response);
			ui = "/02-board/R03Board_detail.jsp";
		}else if(uri.equals("/WebReview/boardupdate.abc")) {		// 글 수정 조회
			System.out.println("글수정");
			sv = new R04Board_detail_service();
			sv.execute(request, response);
			ui = "/02-board/R04Board_update.jsp";
		}else if(uri.equals("/WebReview/boardupdateok.abc")) {		// 글 수정 완료
			System.out.println("글수정");
			ui = "/02-board/R03Board_detail.jsp";
		}else if(uri.equals("/WebReview/boarddelete.abc")) {		// 글 삭제
			System.out.println("글작성");
		}
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}
