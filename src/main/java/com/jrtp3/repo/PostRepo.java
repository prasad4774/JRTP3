package com.jrtp3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp3.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	

}
