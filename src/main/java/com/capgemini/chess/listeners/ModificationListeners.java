package com.capgemini.chess.listeners;

import java.util.Date;

import javax.persistence.PrePersist;
import com.capgemini.chess.dataaccess.entities.BaseEntity;

public class ModificationListeners {

	public class ModificationListener<T extends BaseEntity> {

		@PrePersist
		public void setCreationDate(T entity) {
			entity.setCreationDate(new Date());
		}
	}

}
