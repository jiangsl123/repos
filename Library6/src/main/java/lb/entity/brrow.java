package lb.entity;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class brrow {
	
	@Id					
	@GeneratedValue		
private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private  int num;
	private String  brrowname;
	private String  brrowbook;
	
	public brrow(){
		
	}
	public brrow( int num,String brrowname,String brrowbook)
	{
		this.brrowbook=brrowbook;
		this.brrowname=brrowname;
		this.num=num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBrrowname() {
		return brrowname;
	}
	public void setBrrowname(String brrowname) {
		this.brrowname = brrowname;
	}
	public String getBrrowbook() {
		return brrowbook;
	}
	public void setBrrowbook(String brrowbook) {
		this.brrowbook = brrowbook;
	}
	
}
	
	
	