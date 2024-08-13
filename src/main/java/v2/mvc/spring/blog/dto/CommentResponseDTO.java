package v2.mvc.spring.blog.dto;

public class CommentResponseDTO {
	
	private String cmtBdy;
	private int seqBlgCmt;
	
	
	public String getCmtBdy() {
		return cmtBdy;
	}
	public void setCmtBdy(String cmtBdy) {
		this.cmtBdy = cmtBdy;
	}
	public int getSeqBlgCmt() {
		return seqBlgCmt;
	}
	public void setSeqBlgCmt(int seqBlgCmt) {
		this.seqBlgCmt = seqBlgCmt;
	}
	
	

}
