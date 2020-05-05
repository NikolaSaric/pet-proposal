package com.petproposal.petproposal.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petproposal.petproposal.dto.AnimalDto;
import com.petproposal.petproposal.service.AnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/api/animals")
public class AnimalController {
	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@Operation(description = "Returns an animal by ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User returned."),
			@ApiResponse(responseCode = "404", description = "Animal not found.") })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnimalDto> getAnimal(@PathVariable("id") Long id) {
		return new ResponseEntity<AnimalDto>(animalService.findById(id), HttpStatus.OK);
	}

	@Operation(description = "Adds a new animal.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Animal successfully registered."),
			@ApiResponse(responseCode = "409", description = "Animal with given name already exists.") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnimalDto> addAnimal(
			@Parameter(description = "Animal to be added.") @RequestBody @Valid AnimalDto dto) {

		return new ResponseEntity<AnimalDto>(animalService.save(dto), HttpStatus.CREATED);
	}

	@Operation(description = "Deletes an animal by ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Animal successfully deleted."),
			@ApiResponse(responseCode = "404", description = "Animal with given ID not found.") })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletAnimal(@PathVariable("id") Long id) {
		animalService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
