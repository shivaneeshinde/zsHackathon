package com.zs.hackathon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zs.hackathon.entity.Teams;
import com.zs.hackathon.repository.TeamsRepository;

@Service
@Transactional
public class TeamsService {
	
	private final TeamsRepository teamsRepository;
	
	public TeamsService(TeamsRepository teamsRepository) {
		this.teamsRepository = teamsRepository;
	}

	public List<Teams> getTeamsList() {
	    System.out.println("Inside empList method");	    
		return this.teamsRepository.findAll();
	}
}
