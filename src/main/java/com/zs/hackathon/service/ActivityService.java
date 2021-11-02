package com.zs.hackathon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zs.hackathon.entity.Activities_Scheduled;
import com.zs.hackathon.repository.ActivityRepository;

@Service
@Transactional
public class ActivityService {
	
	private final ActivityRepository activityRepository;

	public ActivityService(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}
	
	
	public List<Activities_Scheduled> getActivityList() {
	    System.out.println("Inside getActivityList method");	    
		return this.activityRepository.findAll();
	}

}
