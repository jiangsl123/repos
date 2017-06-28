package lb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lb.entity.Subjects;
import lb.entity.College;
import lb.repo.SubjectsRepository;
import lb.repo.CollegeRepository;

@Controller
@RequestMapping("/subjects")
public class SubjectsContorller {
	@Autowired
	private SubjectsRepository subjectsRepo;
	
	@Autowired
	private CollegeRepository collegeRepo;
	
	@GetMapping("/")
	public String showsubjectsPage(Model model){
		Iterable subjectsList = subjectsRepo.findAll();
		model.addAttribute("subjectsList", subjectsList);
		return "subjects/subjects";
	}
	
	@GetMapping("/form/{method}/{id}")
	public String showForm(@PathVariable Long id, 
			@PathVariable String method,Model model){
		
		Subjects subjects = new Subjects();
		if(method.equalsIgnoreCase("post")){
			
			model.addAttribute("subjects",subjects );
		}else{
			
			subjects = subjectsRepo.findOne(id);
			model.addAttribute("subjects", subjects);
		}
		
		model.addAttribute("method", method);
		
		
		Iterable<College> colleges = collegeRepo.findAll();
		model.addAttribute("colleges", colleges);
		return "subjects/form";
	}
	@GetMapping("/delsubjects/{id}")
	public String delsubjects(@PathVariable Long id)
	{
		subjectsRepo.delete(id);
		return "redirect:/subjects/";
	}
	//
	@PostMapping("/subjects")
	public String addsubjects(Subjects subjects){
		
		subjectsRepo.save(subjects);
		
		return "redirect:/subjects/";
	}
	//
	@PutMapping("/subjects")
	public String editsubjects(Subjects subjects){
		
		subjectsRepo.save(subjects);
		
		return "redirect:/subjects/";
	}
	
}
