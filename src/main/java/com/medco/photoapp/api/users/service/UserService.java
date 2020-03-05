package com.medco.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.medco.photoapp.api.users.shared.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto userDetails);

	UserDto getUSerDetailsByEmail(String email);
}
