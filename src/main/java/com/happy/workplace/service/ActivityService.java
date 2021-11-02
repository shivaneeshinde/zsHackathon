package com.happy.workplace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.happy.workplace.entity.Activities_Scheduled;
import com.happy.workplace.repository.ActivityRepository;

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
