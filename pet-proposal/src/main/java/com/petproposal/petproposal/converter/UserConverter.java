package com.petproposal.petproposal.converter;

import org.springframework.stereotype.Component;

import com.petproposal.petproposal.dto.UserDto;
import com.petproposal.petproposal.model.User;

@Component
public class UserConverter implements EntityToDtoConverter<User, UserDto> {

	@Override
	public User toEntity(UserDto dto) {
		User user = User.builder()
				.id(dto.getId())
				.email(dto.getEmail())
				.password(dto.getPassword())
				.role(dto.getRole())
				.build();
		
		return user;
	}

	@Override
	public UserDto toDto(User entity) {
		UserDto userDto = UserDto.builder()
				.id(entity.getId())
				.email(entity.getEmail())
				.password(entity.getPassword())
				.role(entity.getRole())
				.build();
		
		return userDto;
	}

}
