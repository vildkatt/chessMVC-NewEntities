package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.EmbeddedPersonalStatement;
import com.capgemini.chess.service.to.EmbeddedPersonalStatementTO;

public class EmbeddedPersonalStatementMapper {
	
	public static EmbeddedPersonalStatementTO map(EmbeddedPersonalStatement personalStatement) {
		if (personalStatement != null) {
			EmbeddedPersonalStatementTO personalTO = new EmbeddedPersonalStatementTO();
			personalTO.setAboutMe(personalStatement.getAboutMe());
			personalTO.setLifeMotto(personalStatement.getLifeMotto());
			
			return personalTO;
		}
		return null;
	}

	public static EmbeddedPersonalStatement map(EmbeddedPersonalStatementTO personalTO) {
		if (personalTO != null) {
			EmbeddedPersonalStatement personalStatement = new EmbeddedPersonalStatement();
			personalStatement.setAboutMe(personalTO.getAboutMe());
			personalStatement.setLifeMotto(personalTO.getLifeMotto());
		
			return personalStatement;
		}
		return null;
	}
	
	public static EmbeddedPersonalStatement update(EmbeddedPersonalStatement personalStatement, EmbeddedPersonalStatementTO personalTO) {
		if (personalTO != null && personalStatement != null) {
			personalStatement.setAboutMe(personalTO.getAboutMe());
			personalStatement.setLifeMotto(personalTO.getLifeMotto());

			
		}
		return personalStatement;
	}
	
	public static List<EmbeddedPersonalStatementTO> map2TOs(List<EmbeddedPersonalStatement> personalStatements) {
		return personalStatements.stream().map(EmbeddedPersonalStatementMapper::map).collect(Collectors.toList());
	}

	public static List<EmbeddedPersonalStatement> map2Entities(List<EmbeddedPersonalStatementTO> personalTOs) {
		return personalTOs.stream().map(EmbeddedPersonalStatementMapper::map).collect(Collectors.toList());
	}


}
