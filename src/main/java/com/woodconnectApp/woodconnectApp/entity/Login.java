package com.woodconnectApp.woodconnectApp.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Login {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;

}
