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

import com.petproposal.petproposal.dto.UserDto;
import com.petproposal.petproposal.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Operation(description = "Returns a user by ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User returned."),
			@ApiResponse(responseCode = "404", description = "User not found.") })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
	}

	@Operation(description = "Registers a new user.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "User successfully registered."),
			@ApiResponse(responseCode = "409", description = "User with given email already exists.") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> registerUser(
			@Parameter(description = "User to be added.") @RequestBody @Valid UserDto dto) {

		return new ResponseEntity<UserDto>(userService.save(dto), HttpStatus.CREATED);
	}

	@Operation(description = "Deletes a user by ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "User successfully deleted."),
			@ApiResponse(responseCode = "404", description = "User with given ID not found.") })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
