package com.zs.hackathon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zs.hackathon.entity.Discussions;
import com.zs.hackathon.repository.DiscussionsRepository;

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
