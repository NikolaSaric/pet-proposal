package com.petproposal.petproposal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petproposal.petproposal.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	Optional<Animal> findByName(String name);
}
