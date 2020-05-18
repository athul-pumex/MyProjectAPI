package com.sample.MyProjectAPI.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "demo_users")
@EntityListeners(AuditingEntityListener.class)
public class Users implements Serializable {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public Users() {
		super();

	}

	@Column(name = "id")
	public	String
			getId() {
		return id;
	}

	public	void
			setId(String id) {
		this.id = id;
	}

	@Column(name = "first_name")
	public	String
			getFirstName() {
		return firstName;
	}

	public	void
			setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public	String
			getLastName() {
		return lastName;
	}

	public	void
			setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public	String
			getEmail() {
		return email;
	}

	public	void
			setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public	String
			getPassword() {
		return password;
	}

	public	void
			setPassword(String password) {
		this.password = password;
	}

}
