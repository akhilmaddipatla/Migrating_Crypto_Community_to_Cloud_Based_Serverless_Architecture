package com.example.CryptoCommunityServer.controllers;

import com.example.CryptoCommunityServer.models.Comment;
import com.example.CryptoCommunityServer.services.CommentService;
import com.example.CryptoCommunityServer.services.UserService;
import com.example.CryptoCommunityServer.services.PostService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/**", method={RequestMethod.OPTIONS})
@CrossOrigin(origins = "https://cryptocommunity.herokuapp.com", allowCredentials = "true")
public class CommentController {

  @Autowired
  CommentService service;
  UserService userService;
  PostService postService;
  List<Comment> comments = new ArrayList<Comment>();

  @PostMapping("/api/posts/{postId}/newComment/{username}")
  public Comment createCommentForPost(
      @PathVariable("username") String username,
      @PathVariable("postId") String pid,
      @RequestBody String newComment,
      HttpSession session
  ){
    Comment generatedComment = new Comment();
    java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
    generatedComment.setPostDate(sqlDate.toString());
    generatedComment.setBody(newComment);
    generatedComment.setAssociatedPost(pid);
    generatedComment.setAuthor(username);
    session.setAttribute("currentUser", newComment);
    comments.add(generatedComment);
    return service.createCommentForPost(generatedComment);
  }

  @GetMapping("/api/posts/{postId}/comments")
  public List<Comment> findCommentsForPost(
      @PathVariable("postId") String pid
  ){
    return service.findCommentsByPost(pid);
  }

  @GetMapping("/api/users/{userId}/myComments")
  public List<Comment> findCommentsForUser(
      @PathVariable("userId") String uid
  ){
    return service.findCommentsByUser(uid);
  }

  @DeleteMapping("/api/post/comments/{commentId}/delete")
  public Integer deletePost(
      @PathVariable("commentId") String cid) {
    return service.deleteCommentById(cid);
  }


}
