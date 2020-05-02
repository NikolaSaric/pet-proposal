package com.petproposal.petproposal.converter;

import com.petproposal.petproposal.dto.AbstractDto;
import com.petproposal.petproposal.model.AbstractEntity;

public interface EntityToDtoConverter<Entity extends AbstractEntity, Dto extends AbstractDto> {
	Entity toEntity(Dto dto);

	Dto toDto(Entity entity);
}
