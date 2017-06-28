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
public class LoginController {
	
@GetMapping("index")
public String Login()
{
	return "/index";
}


@PostMapping("index")
public String dealLogin(String admin_name,String password,Model model)
{
	
	if(admin_name.equals("admin")&&password.equals("admin"))
	    return "redirect:/collegeView";
	else if (admin_name.equals("teacher")&&password.equals("teacher"))
	return "redirect:/books/";

	else
		model.addAttribute("addResult", 0);
	return "/index";
}

@GetMapping("error")
public String Error()
{
	return "/error";
}

}
