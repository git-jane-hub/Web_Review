package kr.co.abc.user.model;

public class R01UserVO {
	private String uId;
	private String uPw;
	private String uName;
	private String uEmail;
	
	public R01UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public R01UserVO(String uId, String uPw, String uName, String uEmail) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uEmail = uEmail;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	@Override
	public String toString() {
		return "R01UserVO [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uEmail=" + uEmail + "]";
	}
	
}
