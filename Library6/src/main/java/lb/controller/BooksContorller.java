 package lb.controller;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lb.entity.Books;
import lb.entity.Subjects;
import lb.entity.brrow;
import lb.repo.BooksRepository;
import lb.repo.BrrowRepository;
import lb.repo.CollegeRepository;
import lb.repo.SubjectsRepository;


@Controller
@RequestMapping("/books/")
public class BooksContorller {
	
	@Autowired
	private BooksRepository booksRepo;
	
	
	@Autowired
	private SubjectsRepository sbujectsRepo;
	

	@Autowired
	private CollegeRepository collegeRepo;
	
	
	@Autowired
	private BrrowRepository brrowRepository;
	
	@GetMapping("/")
	public String showbooksPage(Model model){
		Iterable books = booksRepo.findAll();
		model.addAttribute("books", books);
		model.addAttribute("count", booksRepo.count());
		
		
		model.addAttribute("sbujectsList",sbujectsRepo.findAll());
		model.addAttribute("colleges",collegeRepo.findAll());
		
		return "books/books";
	}
	

	@GetMapping("/form")
	public String showForm(Long id, Model model){
		Books books = new Books();
		if(id != null)
			books = booksRepo.findOne(id);
		model.addAttribute("books", books);
		
		
		Iterable<Subjects> subjectsList = sbujectsRepo.findAll();
		model.addAttribute("subjectsList", subjectsList);
		return "books/form";
	}
	
	
	@PostMapping("/books")
	public String savebooks(Books books,MultipartFile file,
			HttpServletRequest req
			){
		
		booksRepo.save(books);
		
		return "redirect:/books/";
	}
	

	@GetMapping("/booksView/{id}")
	public String showbooksDetailPage(
			@PathVariable("id") Books books,
			Model model){
		model.addAttribute("books", books);
		return "books/booksView";
	}
	
	

	@GetMapping("/queryByNum/{num}")
	public String queryByNum(@PathVariable String num,
			Model model){
		List<Books> books = null;
		if(num == null)
			books = booksRepo.findAll();
		else
			books = booksRepo.findByNumLike(num);
		
		model.addAttribute("books", books);
		model.addAttribute("count", books.size());
		return "books/books::bookssTable";
	}
	
	
	@GetMapping("/queryByname/{name}")
	public String queryByname(@PathVariable String name,
			Model model){
		List<Books> books = null;
		if(name == null)
			books = booksRepo.findAll();
		else
			books = booksRepo.findByBooknameLike(name);
		
		model.addAttribute("books", books);
		model.addAttribute("count", books.size());
		return "books/books::bookssTable";
	}
	
    
	@GetMapping("/delbooks/{id}")
	public String delbooks(@PathVariable Long id)
	{
		booksRepo.delete(id);
		return  "redirect:/books/";
		
	}
	
	
	@GetMapping("visitor")
	public String  visitor(Model model)
	{
		
		List<brrow> brrows = null;

			brrows = brrowRepository.findAll();
	
		
		model.addAttribute("brrow", brrows);
		model.addAttribute("count", brrows.size());		
		return "books/visitor";
	}
	
	
	@GetMapping("visitorform")
	public String  visitorform()
	{
		return "books/visitorform";
	}
	
	@PostMapping("visitorform")
	public String  visitorform2(brrow brrow)
	{
	    brrowRepository.save(brrow);
		return "/books/visitor";
	}
	
}
