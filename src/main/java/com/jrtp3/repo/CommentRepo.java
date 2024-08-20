package com.jrtp3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp3.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
