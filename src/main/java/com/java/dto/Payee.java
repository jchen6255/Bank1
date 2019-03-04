package com.java.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Payee {
	
	@Id
	String nickname;
	int accountNumber;

}
