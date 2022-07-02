package com.example.CryptoCommunityServer.controllers;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import com.example.CryptoCommunityServer.models.NormalUserJoined;
import com.example.CryptoCommunityServer.services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/**", method={RequestMethod.OPTIONS})
@CrossOrigin(origins = "https://cryptocommunity.herokuapp.com", allowCredentials = "true")
public class UserController {

  @Autowired
  UserService service;
  List<BaseUserJoined> users = new ArrayList<BaseUserJoined>();

  @PostMapping("/api/users/register")
  public NormalUserJoined register(
      @RequestBody NormalUserJoined user,
      HttpSession session
  ) {
    session.setAttribute("currentUser", user);
    users.add(user);
    return service.createNormalUser(user);
  }

  @PostMapping("/api/users/login")
  public BaseUserJoined login(
      @RequestBody BaseUserJoined credentials,
      HttpSession session
  ) {
    BaseUserJoined user = service.findUser(credentials.getUsername(), credentials.getPassword());
    BaseUserJoined badUser = new BaseUserJoined();
    badUser.setUsername("BadLogin");
    if (user != null) {
      session.setAttribute("currentUser", user);
      return user;
    }
  return badUser;
  }

  @PostMapping("/api/users/profile")
  public BaseUserJoined profile(HttpSession session) {
    BaseUserJoined currentUser = (BaseUserJoined) session.getAttribute("currentUser");
    return currentUser;
  }

  @PostMapping("/api/users/profile/{profileId}")
  public BaseUserJoined getProfile(
      @PathVariable("profileId") String pId,
      @RequestBody String username
  ) {
    BaseUserJoined currentUser = service.findUserByUsername(username);
    return currentUser;
  }


  @PostMapping("/api/users/{username}/admin")
  public boolean checkIfAdmin(
      @PathVariable("username") String username
  ) {
    return service.checkIfAdmin(username);
  }

  @PostMapping("/api/users/{username}/makeAdmin")
  public Integer makeAdmin(
      @PathVariable("username") String username
  ) {
    return service.makeAdmin(username);
  }

  @PostMapping("/api/users/{username}/{newUsername}/updateUsername")
  public BaseUserJoined updateUserName(
    @PathVariable ("username") String uid,
    @PathVariable ("newUsername") String newUid,
    @RequestBody BaseUserJoined newUser
  ) {
    service.updateUsername(uid, newUid);
    return newUser;
  }

  @PostMapping("api/users/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }
}
