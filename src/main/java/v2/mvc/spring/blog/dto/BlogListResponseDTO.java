package v2.mvc.spring.blog.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlogListResponseDTO {
	
	private int contnum;
	private String title;
	private String contBdy;
	private LocalDateTime insertDt;
	
	
	public int getContnum() {
		return contnum;
	}
	public void setContnum(int contnum) {
		this.contnum = contnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContBdy() {
		return contBdy;
	}
	public void setContBdy(String contBdy) {
		this.contBdy = contBdy;
	}
	public LocalDateTime getInsertDt() {
		return insertDt;
	}
	public void setInsertDt(LocalDateTime insertDt) {
		this.insertDt = insertDt;
	}
	
	public String getInsertDtFormat() {
		return this.insertDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}
