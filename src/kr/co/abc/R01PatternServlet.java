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

import kr.co.abc.board.service.R01Service;
import kr.co.abc.board.service.R02Board_write_service;
import kr.co.abc.board.service.R03Board_select_service;


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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		System.out.println("ui주소: " + ui);
		if(uri.equals("/WebReview/boardwrite.abc")) {			// 글 작성
			System.out.println("글작성");
			sv = new R02Board_write_service();
			sv.execute(request, response);
			ui = "/boardselect.abc";
		}else if(uri.equals("/WebReview/boardselect.abc")) {		// 글 목록 조회
			System.out.println("글목록조회");
			sv = new R03Board_select_service();
			sv.execute(request, response);
			ui = "/02-board/R02Board_list.jsp";
		}else if(uri.equals("/WebReview/boarddetail.abc")) {		// 글 내용 조회
			System.out.println("글내용조회");
		}else if(uri.equals("/WebReview/boardupdate.abc")) {		// 글 수정
			System.out.println("글수정");
		}else if(uri.equals("/WebReview/boarddelete.abc")) {		// 글 삭제
			System.out.println("글작성");
		}
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}
