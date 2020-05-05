package com.petproposal.petproposal.service;

import org.springframework.stereotype.Service;

import com.petproposal.petproposal.converter.AnimalConverter;
import com.petproposal.petproposal.dto.AnimalDto;
import com.petproposal.petproposal.repository.AnimalRepository;

@Service
public class AnimalService {
	private final AnimalRepository animalRepository;

	private final AnimalConverter animalConverter;

	public AnimalService(AnimalRepository animalRepository, AnimalConverter animalConverter) {
		this.animalRepository = animalRepository;
		this.animalConverter = animalConverter;
	}

	public AnimalDto findById(Long id) {
		return animalConverter.toDto(animalRepository.getOne(id));
	}

	public AnimalDto findByName(String name) {
		return animalConverter.toDto(animalRepository.findByName(name).get());
	}

	public AnimalDto save(AnimalDto dto) {
		return animalConverter.toDto(animalRepository.save(animalConverter.toEntity(dto)));
	}

	public void delete(Long id) {
		animalRepository.deleteById(id);
	}
}
