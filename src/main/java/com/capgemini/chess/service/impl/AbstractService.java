package com.capgemini.chess.service.impl;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dao.Dao;
import com.capgemini.chess.dao.impl.AbstractDao;
import com.capgemini.chess.exceptions.EntityNotFoundException;
import com.capgemini.chess.service.Service;

@Transactional(Transactional.TxType.SUPPORTS)
public abstract class AbstractService <T, K extends Serializable> implements Service <T, K> {
	
	@Autowired
	AbstractDao abstractDao;
	
	 public T findOne(K id) throws EntityNotFoundException {
	return null;
		 
	 }

}
