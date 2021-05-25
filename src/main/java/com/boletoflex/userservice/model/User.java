package com.boletoflex.userservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = -4632601128713640176L;

	private Integer id;
	
	@ApiModelProperty(
		value = "User name",
		name= "name",
		dataType = "String")
	private String name;
	
	@ApiModelProperty(
		value = "Email",
		name= "email",
		dataType = "String")
	private String email;
	
	@ApiModelProperty(
		value = "Photo",
		name= "photo",
		dataType = "byte[]")
	private byte[] photo;
	
	@ApiModelProperty(
		value = "Phone",
		name= "phone",
		dataType = "String")
	private String phone;
	
	@ApiModelProperty(
		value = "City",
		name= "city",
		dataType = "String")
	private String city;
	
	@ApiModelProperty(
		value = "State",
		name= "state",
		dataType = "String")
	private String state;
	
	@ApiModelProperty(
		value = "District",
		name= "district",
		dataType = "String")
	private String district;
	
	@ApiModelProperty(
		value = "Street",
		name= "street",
		dataType = "String")
	private String street;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHOTO")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "DISTRICT")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "STREET")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
