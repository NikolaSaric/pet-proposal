package com.petproposal.petproposal.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class User extends AbstractEntity {

    @NotNull(message = "User email must not be null.")
    @Email(message = "User email must be in a format: something@etc")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "User password must not be null.")
    @NotBlank(message = "User password must not be blank.")
    @Column(unique = false, nullable = false)
    private String password;

    @NotNull(message = "User role must not be null.")
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private Role role;

    public User() {
    }

    public User(UserBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        User otherUser = (User) obj;

        return this.email.equals(otherUser.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.email);
    }

    @Override
    public String toString() {
        return "User: email: " + email + ", role: " + role.toString();
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

    public static class UserBuilder {
        private Long id;
        private String email;
        private String password;
        private Role role;

        public UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

    }

}
