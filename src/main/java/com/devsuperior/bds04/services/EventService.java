package com.devsuperior.bds04.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	
	public Page<EventDTO> findAllPaged(Pageable pageable) {
		Page<Event> list = repository.findAll(pageable);
		return list.map(x -> new EventDTO(x));		
		
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());		
		entity.setUrl(dto.getUrl());
		entity.setDate(dto.getDate());
		
		
		entity = repository.save(entity);
		return new EventDTO(entity);			
		
		
	}
	
}
