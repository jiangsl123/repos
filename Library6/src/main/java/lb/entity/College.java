package lb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class College {
	@Id
	@GeneratedValue
	private Long id;
	
	private String abbr;
	public String name;
	private String desc;
	
	
	public College(){};
	
	
	public College(String abbr,String name){
		this.abbr = abbr;
		this.name = name;
	}
	
	public College(Long id,String abbr,String name){
		this.id = id;
		this.abbr = abbr;
		this.name = name;
	}
	
	public String getAbbr(){
		return this.abbr;
	}
	
	public void setAbbr(String abbr){
		this.abbr = abbr;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
