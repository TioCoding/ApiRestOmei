package com.rest.omei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.omei.entity.Salon;
import com.rest.omei.serviceinterface.SalonManager;

@RestController
@RequestMapping("/salon")
public class SalonController {

	private SalonManager salonManager;

	@Autowired
	public SalonController(SalonManager salonManager) {
		this.salonManager = salonManager;
	}

	@GetMapping
	public List<Salon> getAllSalones() {
		return salonManager.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Salon> getSalon(@PathVariable Long id) {
		Salon salon = salonManager.findById(id);
		if (salon == null)
			return new ResponseEntity<Salon>(salon, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Salon>(salon, HttpStatus.OK);
	}
}
