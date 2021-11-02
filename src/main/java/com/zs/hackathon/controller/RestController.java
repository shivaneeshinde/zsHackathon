package com.zs.hackathon.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zs.hackathon.entity.Activities_Scheduled;
import com.zs.hackathon.entity.Discussions;
import com.zs.hackathon.entity.Event_Type;
import com.zs.hackathon.entity.Login;
import com.zs.hackathon.entity.Teams;
import com.zs.hackathon.entity.Users;
import com.zs.hackathon.exception.ResourceNotFoundException;
import com.zs.hackathon.service.ActivityService;
import com.zs.hackathon.service.DiscussionsService;
import com.zs.hackathon.service.EventService;
import com.zs.hackathon.service.TeamsService;
import com.zs.hackathon.service.UserService;


@CrossOrigin(origins = "http://happyworkplace.herokuapp.com")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeamsService teamsService;

	@Autowired
	private DiscussionsService discussionsService;

	@Autowired
	private EventService eventService;

	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/healthCheck")
	public String check()
	{
		return "checked";
	}	
	
	@PostMapping("/login")
	public Users login(@RequestBody Login login) throws ResourceNotFoundException {
	    System.out.println("Inside login method");
	    String originalInput = login.getPassword();
	    String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
	    System.out.println("Encoded password is: "+encodedString);
	    login.setPassword(encodedString);
	    Users user = userService.login(login);
		return user;
	}

	@GetMapping("/teamsList")
	public List<Teams> teamsList() {
	    System.out.println("Inside teamsList method");
		List<Teams> teams = teamsService.getTeamsList();
		return teams;
	}

	@GetMapping("/discussionList")
	public List<Discussions> discussionList() {
	    System.out.println("Inside discussionList method");
		List<Discussions> discussions = discussionsService.getDiscList();
		return discussions;
	}

	@GetMapping("/getEventList")
	public List<Event_Type> getEventList() {
	    System.out.println("Inside getEventList method");
		List<Event_Type> event = eventService.getEventList();
		return event;
	}

	@GetMapping("/getActivityList")
	public List<Activities_Scheduled> getActivityList() {
	    System.out.println("Inside getActivityList method");
		List<Activities_Scheduled> activity = activityService.getActivityList();
		return activity;
	}
	
}
