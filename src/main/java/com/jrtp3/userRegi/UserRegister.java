package com.jrtp3.userRegi;

import java.util.List;

import com.jrtp3.entity.Comment;
import com.jrtp3.entity.Post;
import com.jrtp3.entity.User;

public interface UserRegister {
	
	public void saveUser1(User user);
	
	public String login(User user);

	public String create(Post  post);
	
	public User displyPost(Integer UserId);
	
	public List<Post> postbyuserId1(Integer userId);
	public List<Post> getall();
	
	public List<Comment> allcom();
}
