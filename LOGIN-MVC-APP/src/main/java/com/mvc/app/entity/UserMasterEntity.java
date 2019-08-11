package com.mvc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_MASTER")
public class UserMasterEntity {
	@Id
	@Column
	@GeneratedValue(generator = "USERID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name ="USERID_SEQ",initialValue =100000,allocationSize = 1)
	private Long userId;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String gender;
	@Column
	private Long phno;
}
