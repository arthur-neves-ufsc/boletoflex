package com.boletoflex.userservice.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boletoflex.userservice.dto.UserDTO;
import com.boletoflex.userservice.exception.BusinessException;
import com.boletoflex.userservice.model.User;
import com.boletoflex.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	public List<User> listUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> findUserById(Integer userId) {
		return userRepository.findById(userId);
	}
	
	public Integer save(UserDTO userDTO) {
		validate(userDTO);
		return userRepository.save(userDTO.getUser()).getId();
	}

	private void validate(UserDTO userDTO) {
		
		if (StringUtils.isBlank(userDTO.getName())) {
			throw new BusinessException(BusinessException.USER_WITHOUT_NAME);
		}
		
		if (StringUtils.isBlank(userDTO.getEmail())) {
			throw new BusinessException(BusinessException.USER_WITHOUT_EMAIL);
		}
		
		if (ArrayUtils.isEmpty(userDTO.getPhoto())) {
			throw new BusinessException(BusinessException.USER_WITHOUT_PHONE); 
		}
	}
}
