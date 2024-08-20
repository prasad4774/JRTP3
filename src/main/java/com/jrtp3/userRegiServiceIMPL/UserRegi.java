package com.jrtp3.userRegiServiceIMPL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrtp3.entity.Comment;
import com.jrtp3.entity.Post;
import com.jrtp3.entity.User;
import com.jrtp3.repo.CommentRepo;
import com.jrtp3.repo.PostRepo;
import com.jrtp3.repo.UserRepo;
import com.jrtp3.userRegi.UserRegister;

@Service
public class UserRegi implements UserRegister{
	
	@Autowired
	private PostRepo  postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private  UserRepo userRepo;
	@Autowired
	private HttpSession httpSession;

	@Override
	public void saveUser1(User user) {
		userRepo.save(user);
		
	}

	@Override
	public String login(User user) {
		
		 User user2 = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(user2==null)
		{
			return "Email or Password Id incorrect";
		}
		
		
		httpSession.setAttribute("userId",user2.getUserId());
		
		
		return"success";
	}

	@Override
	public String create(Post post) {
		
		
		postRepo.save(post);
		
		return"postAdd";
		
	}

	@Override
	public User displyPost(Integer UserId) {
		
	     Optional<User> user = userRepo.findById(UserId);
		if(user.isPresent())
		{
			return user.get();
		}
		else {
		return null;
		}
	}

	@Override
	public List<Post> getall() {
		
		
		List<Post> list = postRepo.findAll();
		return list;
	}

	@Override
	public List<Post> postbyuserId1(Integer userId) {
		System.out.println("User Id from User Regi"+ userId);
		List<Post> postal= new ArrayList<Post>();
		Optional<User> user = userRepo.findById(userId);
List<?> collect = user.stream().map(i-> i.getPost().getClass()).collect(Collectors.toList());
//		
//             List<?> obj= Arrays.asList(collect);
//             System.out.println(obj);
//		 for(Object p : collect)
//		 {
//			 postal.add(null);
//			 System.out.println(postal.toString());
//		 }
//		

//collect.get();
//
//Iterator<?> iterator = collect.iterator();
//
//     while(iterator.hasNext())
//     {
//    	      Object object = iterator.next();
//    	      
//    	      System.out.println(object);
//     }
		return postal;
	}

	@Override
	public List<Comment> allcom() {
		  List<Comment> list = commentRepo.findAll();
		return list;
	}

	

	


}
