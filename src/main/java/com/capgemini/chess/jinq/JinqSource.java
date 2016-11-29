package com.capgemini.chess.jinq;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.stereotype.Component;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@Component
public class JinqSource {

		private JinqJPAStreamProvider streams;

		@PersistenceUnit
		public void setEntityManagerFactory(EntityManagerFactory emf) throws Exception {
			streams = new JinqJPAStreamProvider(emf);
		}

		public <U> JPAJinqStream<U> streamAll(EntityManager em, Class<U> entity) {
			return streams.streamAll(em, entity);
		}

		public JPAJinqStream<UserEntity> users (EntityManager em) {
			return streams.streamAll(em, UserEntity.class);
		}

	}

