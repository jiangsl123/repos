package lb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.internal.ArrayIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lb.entity.College;
import lb.repo.CollegeRepository;

@Controller
public class CollegeController {

	@Autowired
	private CollegeRepository collegeRepository;
	
	
	@GetMapping("/")
	public String showHomePage(){
		return "/index";	
	}
	
	
	@GetMapping("/collegeView")
	public String showCollegePage(Model model){
		Iterable colleges = collegeRepository.findAll();
		model.addAttribute("colleges", colleges);

		return "/college";
	}
	
	
	@GetMapping("/collegeForm")
	public String showCollegeForm(Long id,Model model){
		College college = new College(); 
		if(id != null)
			college = collegeRepository.findOne(id);
		model.addAttribute("college", college);
		return "collegeForm";
	}
	

	@PostMapping("/college")
	public String updateCollege(College college){
		collegeRepository.save(college);
		return "redirect:/collegeView";
	}
	
	
	@GetMapping("/delCollege/{id}")
	public String delCollege(@PathVariable Long id){
		
		collegeRepository.delete(id);
		return "redirect:/collegeView";
	}
	
}
