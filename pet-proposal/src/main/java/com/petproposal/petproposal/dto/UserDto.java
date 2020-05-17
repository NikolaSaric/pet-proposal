package com.petproposal.petproposal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.petproposal.petproposal.PetProposalApplication;
import com.petproposal.petproposal.model.Role;
import com.petproposal.petproposal.validation.Password;

public class UserDto implements AbstractDto {

	private Long id;
	@NotNull(message = "User email must not be null.")
	@Email(message = "User email must be in a format: something@etc")
	private String email;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "User password must not be null.")
	@NotBlank(message = "User password must not be blank.")
	@Password(message = "User password must at least be 7 chars long, contain 1 uppercase letter, one number and no special characters.")
	private String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "User role must not be null.")
	private Role role;

	public UserDto(UserDtoBuilder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.role = builder.role;
	}

	public static UserDtoBuilder builder() {
		return new UserDtoBuilder();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static class UserDtoBuilder {
		private Long id;
		private String email;
		private String password;
		private Role role;

		public UserDtoBuilder() {
		}

		public UserDto build() {
			return new UserDto(this);
		}

		public UserDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public UserDtoBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserDtoBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserDtoBuilder role(Role role) {
			this.role = role;
			return this;
		}
	}

}
