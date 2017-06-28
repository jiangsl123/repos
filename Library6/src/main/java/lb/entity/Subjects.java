package lb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subjects {
	
	@Id					
	@GeneratedValue		
	private Long id;     
	private String code;  
	public String name;    
	@ManyToOne
	@JoinColumn(name="college_id") 
	private College college;
	
	public Subjects(){}
	public Subjects(String code,String name){
		this.code = code;
		this.name = name;
	}
	
	public Subjects(Long id, String code,String name){
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
}
