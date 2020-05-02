package com.petproposal.petproposal.exception;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.petproposal.petproposal.dto.ErrorDetailsDto;

@ControllerAdvice
public class GlobalExceptionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { EntityNotFoundException.class, EmptyResultDataAccessException.class })
	public ResponseEntity<ErrorDetailsDto> handleNotFoundExceptions(Exception exception) {
		return genericHandler(exception, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(value = { ConstraintViolationException.class, DataIntegrityViolationException.class,
			MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorDetailsDto> handleConflictExceptions(Exception exception) {
		return genericHandler(exception, HttpStatus.CONFLICT);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorDetailsDto> handleExceptions(Exception exception) {
		return genericHandler(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<ErrorDetailsDto> genericHandler(Exception exception, HttpStatus httpStatus) {
		logger.error("An exception occured!", exception);

		return new ResponseEntity<>(new ErrorDetailsDto(exception.getMessage(), LocalDate.now(), httpStatus),
				httpStatus);

	}

}
