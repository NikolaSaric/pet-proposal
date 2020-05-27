package com.petproposal.petproposal.controller;

import javax.validation.Valid;

import com.petproposal.petproposal.dto.ResultDto;
import com.petproposal.petproposal.dto.UserInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petproposal.petproposal.dto.AnimalDto;
import com.petproposal.petproposal.service.AnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Operation(description = "Returns an animal by ID.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User returned."),
            @ApiResponse(responseCode = "404", description = "Animal not found.")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnimalDto> getAnimal(@PathVariable("id") Long id) {
        return new ResponseEntity<AnimalDto>(animalService.findById(id), HttpStatus.OK);
    }

    @Operation(description = "Adds a new animal.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Animal successfully registered."),
            @ApiResponse(responseCode = "409", description = "Animal with given name already exists.")})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnimalDto> addAnimal(
            @Parameter(description = "Animal to be added.") @RequestBody @Valid AnimalDto dto) {

        return new ResponseEntity<AnimalDto>(animalService.save(dto), HttpStatus.CREATED);
    }

    @Operation(description = "Deletes an animal by ID.")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Animal successfully deleted."),
            @ApiResponse(responseCode = "404", description = "Animal with given ID not found.")})
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") Long id) {
        animalService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @Operation(description = "Proposes animal for given data.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Animal successfully proposed.")
    })
    @PostMapping(value = "/propose-animal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResultDto>> proposeAnimal(
            @Parameter(description = "Given user data.") @RequestBody @Valid UserInfoDto dto) {

        return new ResponseEntity<List<ResultDto>>(animalService.proposeAnimal(dto), HttpStatus.OK);
    }
}
