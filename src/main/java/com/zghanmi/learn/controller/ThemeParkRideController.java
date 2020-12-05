package com.zghanmi.learn.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import com.zghanmi.learn.entity.ThemeParkRide;
import com.zghanmi.learn.repository.ThemeParkRideRepository;

@RestController
public class ThemeParkRideController {

	private final ThemeParkRideRepository themeParkRideRepository;
	
	public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
		this.themeParkRideRepository = themeParkRideRepository;
	}
	
	@GetMapping(value="/ride", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<ThemeParkRide> getRides(){
		return themeParkRideRepository.findAll();
	}
	
	@GetMapping(value="/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide getRide(@PathVariable Long id){
		return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
	}
	
	@PostMapping(value="/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide){
		return themeParkRideRepository.save(themeParkRide);
	}
}
