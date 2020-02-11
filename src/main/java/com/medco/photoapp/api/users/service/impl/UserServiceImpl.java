package com.medco.photoapp.api.users.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medco.photoapp.api.users.data.UserEntity;
import com.medco.photoapp.api.users.data.UsersRepository;
import com.medco.photoapp.api.users.service.UserService;
import com.medco.photoapp.api.users.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private UsersRepository userRepository;

	@Autowired
	public UserServiceImpl(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		userRepository.save(userEntity);
		return null;
	}

}
