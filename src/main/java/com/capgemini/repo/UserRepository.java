package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
