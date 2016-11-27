package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3596628968257400542L;
	
	
	@Version
	public long version;
	
	@CreatedDate
	private Date creationDate;
}
