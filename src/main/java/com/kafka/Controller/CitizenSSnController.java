package com.kafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.Entity.CitizenSSnEntity;
import com.kafka.Entity.IESform;
import com.kafka.Service.CitizenSSnServiceImpl;

@RestController
public class CitizenSSnController {

	@Autowired
	private CitizenSSnServiceImpl impl;

	@GetMapping("/ssn")
	public ResponseEntity<CitizenSSnEntity> getCitizenBySSn(@PathVariable String ssn) {

		return ResponseEntity.ok(impl.getBySsn(ssn));
	}

	@PostMapping("/iesform")
	public void CreateIEsForm(@RequestBody IESform form) {
		impl.CreateIESForm(form);
	}

	// American govt citizens data loaded
	@PostMapping("/load")
	public void CreateCitizen(@RequestBody IESform form) {
		impl.CreateCitizen(form);
	}

}
