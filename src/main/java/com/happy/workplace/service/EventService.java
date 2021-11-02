package com.happy.workplace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.happy.workplace.entity.Event_Type;
import com.happy.workplace.repository.EventRepository;

@Service
@Transactional
public class EventService {
	
	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event_Type> getEventList() {
	    System.out.println("Inside getEventList method");	    
		return this.eventRepository.findAll();
	}

}
