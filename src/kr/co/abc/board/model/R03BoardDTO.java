package kr.co.abc.board.model;

import java.util.List;

public class R03BoardDTO {
	private int currentPage;
	private int total;
	private List<R01BoardVO> boardList; // List
	private int totalPage;
	private int startPage;
	private int endPage;
	
	public R03BoardDTO(int currentPage, int total, List<R01BoardVO> boardList) {
		this.currentPage = currentPage;
		this.total = total;
		this.boardList = boardList;
		
		if(total == 0) {
			this.totalPage = 0;
			this.startPage = 0;
			this.endPage = 0;
		}else {
			this.totalPage = (total / 10) + 1;
			if(total % 10 == 0) {
				this.totalPage = (total / 10);
			}
			this.startPage = (currentPage / 10) * 10 + 1;
			if(currentPage % 10 == 0) {
				this.startPage = currentPage + (10 - 1);
			}
			this.endPage = this.startPage + (10 - 1);
			// 마지막 페이지가 총 페이지보다 클경우 추가 
			if(this.endPage > this.totalPage) {
				this.endPage = this.totalPage;
			}
		}
	}
	
	public int getTotal() {
		return total;
	}
	public boolean noHasBoard() {
//		if(total == 0) {
//			return true;
//		}
//		return false;
		return total == 0;
	}
	public boolean hasBoard() {
//		if(total > 0) {
//			return true;
//		}
//		return false;
		return total > 0;
	}
	public List<R01BoardVO> getBoardList(){
		return boardList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}

	@Override
	public String toString() {
		return "R03BoardDTO [currentPage=" + currentPage + ", total=" + total + ", boardList=" + boardList
				+ ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
