package com.example.CryptoCommunityServer.controllers;

import com.example.CryptoCommunityServer.services.UserService;
import com.example.CryptoCommunityServer.models.Post;
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
public class PostController {

  @Autowired
  PostService service;
  UserService userService;
  List<Post> posts = new ArrayList<Post>();

  @PostMapping("/api/users/{userId}/posts")
  public Post createPost(
      @PathVariable("userId") String uid,
      @RequestBody Post post,
      HttpSession session
  ) {
    System.out.println(post.toString());
    Post generatedPost = new Post();
    java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
    generatedPost.setPostDate(sqlDate.toString());
    generatedPost.setBody(post.getBody());
    generatedPost.setTitle(post.getTitle());
    generatedPost.setAuthor(uid);
    generatedPost.setFlagged(false);
    posts.add(generatedPost);
    return service.createPost(generatedPost);
  }

  @GetMapping("/api/users/{userId}/userPosts")
  public List<Post> findPostByUserId(
      @PathVariable("userId") String uid
  ) {
    return service.findPostByUserId(uid);
  }

  @GetMapping("/api/getPost/{postId}")
  public Post findPostById(
      @PathVariable("postId") String pid
  ) {
    return service.findPostById(pid);
  }

  @GetMapping("/api/posts")
  public List<Post> findRecentPosts() {
    System.out.println(service.findRecentPosts());
    return service.findRecentPosts();
  }

  @DeleteMapping("/api/posts/{postId}")
  public Integer deletePost(
      @PathVariable("postId") String pid) {
    return service.deletePostById(pid);
  }
}
