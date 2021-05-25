package com.boletoflex.userservice.dto;

import org.apache.tomcat.util.codec.binary.Base64;

import com.boletoflex.userservice.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {
	
	private static final String BASE64 = "base64,";
	
	private User user;
	
	public UserDTO() {
		user = new User();
	}
	
	public UserDTO(User user) {
		this.user = user;
	}
	
	@JsonIgnore
    public User getUser() {
        return user;
    }
	
	public String getName() {
		return user.getName();
	}
	
	public void setName(String name) {
		user.setName(name);
	}
	
	public String getEmail() {
		return user.getEmail();
	}
	
	public void setEmail(String email) {
		user.setEmail(email);
	}
	
	public byte[] getPhoto() {
		return user.getPhoto();
	}
	
	public void setPhoto(String photo) {
		String base64 = photo.contains(BASE64) ? photo.split(BASE64)[1] : photo;
        byte[] bytes = Base64.decodeBase64(base64);
	   	user.setPhoto(bytes);
	}
	
	public String getPhone() {
		return user.getPhone();
	}
	
	public void setPhone(String phone) {
		user.setPhone(phone);
	}
	
	public String getCity() {
		return user.getCity();
	}
	
	public void setCity(String city) {
		user.setCity(city);
	}
	
	public String getState() {
		return user.getState();
	}
	
	public void setState(String state) {
		user.setState(state);
	}
	
	public String getDistrict() {
		return user.getDistrict();
	}
	
	public void setDistrict(String district) {
		user.setDistrict(district);
	}
	
	public String getStreet() {
		return user.getStreet();
	}
	
	public void setStreet(String street) {
		user.setStreet(street);
	}
}
