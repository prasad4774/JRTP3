package com.jrtp3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp3.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	
	public User findByEmailAndPassword(String email, String pwd);

}
