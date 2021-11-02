package com.happy.workplace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.happy.workplace.entity.Discussions;
import com.happy.workplace.repository.DiscussionsRepository;

@Service
@Transactional
public class DiscussionsService {
	
	private final DiscussionsRepository discussionsRepository;

	public DiscussionsService(DiscussionsRepository discussionsRepository) {
		this.discussionsRepository = discussionsRepository;
	}
	
	public List<Discussions> getDiscList() {
	    System.out.println("Inside getDiscList method");	    
		return this.discussionsRepository.findAll();
	}

}
