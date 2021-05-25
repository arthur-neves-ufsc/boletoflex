package com.boletoflex.userservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boletoflex.userservice.dto.UserDTO;
import com.boletoflex.userservice.exception.NotFoundException;
import com.boletoflex.userservice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController extends ApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@ApiOperation("List users")
	public List<UserDTO> listUsers() {
		
		return userService.listUsers()
				.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
	}
	
	@GetMapping("/users/{userId}")
	@ApiOperation("Find user by id")
	public UserDTO findUserById(@PathVariable Integer userId) {
		return new UserDTO(userService.findUserById(userId).orElseThrow(() -> new NotFoundException(NotFoundException.USER_NOT_FOUND)));
	}
	
	@PostMapping("/users")
	@ApiOperation("Save user")
	public Integer save(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
}
