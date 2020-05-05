package com.petproposal.petproposal.converter;

import org.springframework.stereotype.Component;

import com.petproposal.petproposal.dto.AnimalDto;
import com.petproposal.petproposal.model.Animal;

@Component
public class AnimalConverter implements EntityToDtoConverter<Animal, AnimalDto> {

	@Override
	public Animal toEntity(AnimalDto dto) {
		Animal animal = Animal.builder()
				.id(dto.getId())
				.name(dto.getName())
				.spaceNeeded(dto.getSpaceNeeded())
				.timeNeeded(dto.getTimeNeeded())
				.potentialNoise(dto.getPotentialNoise())
				.hairAlergy(dto.getHairAlergy())
				.featherAlergy(dto.getFeatherAlergy())
				.moneyNeeded(dto.getMoneyNeeded())
				.pettable(dto.getPettable())
				.absenceFromHome(dto.getAbsenceFromHome())
				.activities(dto.getActivities())
				.learningTricks(dto.getLearningTricks())
				.build();
		
		return animal;
	}

	@Override
	public AnimalDto toDto(Animal entity) {
		AnimalDto animalDto = AnimalDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.spaceNeeded(entity.getSpaceNeeded())
				.timeNeeded(entity.getTimeNeeded())
				.potentialNoise(entity.getPotentialNoise())
				.hairAlergy(entity.getHairAlergy())
				.featherAlergy(entity.getFeatherAlergy())
				.moneyNeeded(entity.getMoneyNeeded())
				.pettable(entity.getPettable())
				.absenceFromHome(entity.getAbsenceFromHome())
				.activities(entity.getActivities())
				.learningTricks(entity.getLearningTricks())
				.build();
		
		return animalDto;
	}

}
