package com.example.mywebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	UserRepo repo;
	@RequestMapping("home")
	public String homepage() {
		return "home.jsp";
	}
	@RequestMapping("Login")
	public ModelAndView loginform(@RequestParam("uname") String uname,@RequestParam("pass") String pass) {
		ModelAndView mv=new ModelAndView("welcome.jsp");
		User u=repo.findById(pass).orElse(null);
		if(u==null){
			System.out.println("uu");
			mv.setViewName("login.jsp");
			return mv;
		}
		else {
			System.out.println("pp");
			mv.setViewName("welcome.jsp");
			mv.addObject("Name", uname);
			return mv;
		}
	}
	@RequestMapping("Create")
	public String create(User u) {
		repo.save(u);
		return "home.jsp";
		
	}
	
}
