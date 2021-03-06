package com.petproposal.petproposal.dto;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.petproposal.petproposal.dto.AbstractDto;

public class ErrorDetailsDto implements AbstractDto {
	private String message;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate timestamp;
	private Integer status;
	private String error;

	public ErrorDetailsDto() {
	}

	public ErrorDetailsDto(String message, LocalDate timestamp, HttpStatus httpStatus) {
		this.message = message;
		this.timestamp = timestamp;
		this.status = httpStatus.value();
		this.error = httpStatus.name();

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
