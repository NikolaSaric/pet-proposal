package com.petproposal.petproposal.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.petproposal.petproposal.converter.UserConverter;
import com.petproposal.petproposal.dto.UserDto;
import com.petproposal.petproposal.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	private UserConverter userConverter;

	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, UserConverter userConverter, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.userConverter = userConverter;
		this.passwordEncoder = passwordEncoder;
	}

	public UserDto findById(Long id) {
		return userConverter.toDto(userRepository.getOne(id));
	}

	public UserDto findByEmail(String email) {
		return userConverter.toDto(userRepository.findByEmail(email).get());
	}

	public UserDto save(UserDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		return userConverter.toDto(userRepository.save(userConverter.toEntity(dto)));
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
