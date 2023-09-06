package com.indianbank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class PasswordReset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long userId;
	private String email;
	@Transient // Marking the email field as transient
	private String userPassword;

	public PasswordReset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordReset(Long id, Long userId, String email, String userPassword) {
		super();
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "PasswordReset [id=" + id + ", userId=" + userId + ", email=" + email + ", userPassword=" + userPassword
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
