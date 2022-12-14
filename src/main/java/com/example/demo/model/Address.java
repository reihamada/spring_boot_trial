package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address3")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "address_id")
	private Long address_id;

	@Column(name = "address")
	private String address;

	@Column(name = "address2")
	private String address2;

	@Column(name = "district")
	private String district;

	@Column(name = "city_id")
	private Integer city_id;

	@Column(name = "postal_code")
	private String postal_code;

	@Column(name = "phone")
	private String phone;

//	@Column(name = "locationpoint", columnDefinition = "POINT")
//	private Point location;

	@Column(name = "last_update")
	private Timestamp last_update;
}
