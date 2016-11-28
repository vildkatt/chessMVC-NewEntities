package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.EmbeddedPersonalStatement;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserProfileMapper {
	
	public static UserProfileTO map(UserEntity userEntity) {
		if (userEntity != null) {
			UserProfileTO userTO = new UserProfileTO();
			userTO.setEmail(userEntity.getEmail());
			userTO.setId(userEntity.getId());
			userTO.setLogin(userEntity.getLogin());
			userTO.setName(userEntity.getName());
			userTO.setPassword(userEntity.getPassword());
			userTO.setSurname(userEntity.getSurname());
			userTO.setPersonalStatementTO(EmbeddedPersonalStatementMapper.map(userEntity.getPersonalStatement()));
			return userTO;
		}
		return null;
	}

	public static UserEntity map(UserProfileTO userTO) {
		if (userTO != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setEmail(userTO.getEmail());
			userEntity.setId(userTO.getId());
			userEntity.setLogin(userTO.getLogin());
			userEntity.setName(userTO.getName());
			userEntity.setPassword(userTO.getPassword());
			userEntity.setSurname(userTO.getSurname());
			userEntity.setPersonalStatement(EmbeddedPersonalStatementMapper.map(userTO.getPersonalStatementTO()));
			return userEntity;
		}
		return null;
	}
	
	public static UserEntity update(UserEntity userEntity, UserProfileTO userTO) {
		if (userTO != null && userEntity != null) {
			userEntity.setEmail(userTO.getEmail());
			userEntity.setName(userTO.getName());
			userEntity.setPassword(userTO.getPassword());
			userEntity.setSurname(userTO.getSurname());
			userEntity.setPersonalStatement(EmbeddedPersonalStatementMapper.map(userTO.getPersonalStatementTO()));
		}
		return userEntity;
	}
	
	public static List<UserProfileTO> map2TOs(List<UserEntity> userEntities) {
		return userEntities.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}

	public static List<UserEntity> map2Entities(List<UserProfileTO> userTOs) {
		return userTOs.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}
}
