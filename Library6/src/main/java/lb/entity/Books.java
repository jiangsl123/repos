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
public class Books {
	
	@Id					
	@GeneratedValue		
	private Long id;
	private String num;
	public String college;	
	public  String subject;
	public  String bookname;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date publicationday;	

	
	@ManyToOne
	@JoinColumn(name="Sbujects")//添加学科
	private Subjects Subjects;
	//
	public Books(){}
	
	public Books(Long id,String num,String college,String subject,
			String bookname,Date publicationday){
		this.id = id;
		this.num = num;
		this.college = college;
		this.subject = subject;
		this.bookname = bookname;
		this.publicationday = publicationday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Date getPublicationday() {
		return publicationday;
	}

	public void setPublicationday(Date publicationday) {
		this.publicationday = publicationday;
	}

	public Subjects getSubjects() {
		return Subjects;
	}

	public void setSubjects(Subjects subjects) {
		Subjects = subjects;
	}
	
	

}
	
	
	