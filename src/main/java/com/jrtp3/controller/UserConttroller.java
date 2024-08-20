package com.jrtp3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrtp3.entity.Comment;
import com.jrtp3.entity.Post;
import com.jrtp3.entity.User;
import com.jrtp3.userRegi.UserRegister;

@Controller
public class UserConttroller {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserRegister userRegister;

	@GetMapping("/")
	public String indexpage(Model model)
	{

		List<Post> list = userRegister.getall();
	
		Integer userId = (Integer) httpSession.getAttribute("userId");
		 List<Post> postbyuserId1 = userRegister.postbyuserId1(userId);
		 
		 System.out.println(userId);
		 System.out.println(postbyuserId1.toString());
		
		model.addAttribute("post", list);
		
		
		return "index";
	}
	
	
	@GetMapping("/register")
	public String registerPage(Model model)
	{
		model.addAttribute("user", new User());
		
		return"register";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user)
	{
//		System.out.println(user);
		userRegister.saveUser1(user);
		
		return "index";
	}
	
	
	@GetMapping("/login")
	public String loginPage(Model  model)
	{
	  model.addAttribute("login", new User());
		
		return"login";
	}
	
	
	
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("login") User user , Model model)
	{
		String status = userRegister.login(user);
		
		if(status.contains("success"))
		{
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("erroMSG", "Login Unsuccessfuly");
		}
		
		return"login";
	}
	
	@GetMapping("/dashboard")
    public String dashboardPage(Model model)
    {
		Integer userId = (Integer) httpSession.getAttribute("userId");
		
		List<Post> list = userRegister.getall();
		User user = userRegister.displyPost(userId);
		model.addAttribute("post", list);
		
		
		
		return"dashboard";
    }
	
	@GetMapping("new-post")
	public String newPost(Model model)
	{
		model.addAttribute("post", new Post());
		return "createpost";
	}
	
	@PostMapping("/create-post")
	public String createPost(@ModelAttribute Post post,Model model)
	{
		
		String create = userRegister.create(post);
		if(create.contains("postAdd"))
		{
			return"redirect:/dashboard";
		}
		else {
			model.addAttribute("errorMSG", "Post Not Add");
			
		}
		
		
		return"createpost";
		
	}
	
	@GetMapping("/post")
	public String post(Model model)
	{
		List<Post> list = userRegister.getall();
	
		Integer userId = (Integer) httpSession.getAttribute("userId");
		 List<Post> postbyuserId1 = userRegister.postbyuserId1(userId);
		 
		 System.out.println(userId);
		 System.out.println(postbyuserId1.toString());
		
		model.addAttribute("post", list);
		return"post";
	}
	
   @GetMapping("/logout")
   public String logoutPage()
   {
	  return "index";
   }

   @GetMapping("/learn")
	public String learnPage(Model model)
	{
	
	   List<Post> list = userRegister.getall();
	          
		
		Integer userId = (Integer) httpSession.getAttribute("userId");
		 List<Post> postbyuserId1 = userRegister.postbyuserId1(userId);
		 
		 List<Comment> allcom = userRegister.allcom();
		 
		
		
		model.addAttribute("post", list);
		model.addAttribute("com", allcom);
		
		return "learn";
	}
	
	@GetMapping("/all-posts")
	public String abc(Model model)
	{
		List<Post> list = userRegister.getall();
		
		Integer userId = (Integer) httpSession.getAttribute("userId");
		 List<Post> postbyuserId1 = userRegister.postbyuserId1(userId);
		 
		 System.out.println(userId);
		 System.out.println(postbyuserId1.toString());
		
		model.addAttribute("post", list);
		return"index";
	}
	
}
