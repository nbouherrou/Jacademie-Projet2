package org.jacademie.projet2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.hibernate.SessionFactory;
import org.jacademie.projet2.dao.SongsDao;
import org.jacademie.projet2.domain.Chanson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongsDaoImpl implements SongsDao {

	private static org.apache.logging.log4j.Logger logger = LogManager
			.getLogger(SongsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Chanson> retrieveAllSongs() throws Exception {
		
		logger.info("Retrieving all Albums ...");
		
		List<Chanson> result = new ArrayList<Chanson>();
		
		result = this.sessionFactory.openSession().createCriteria(Chanson.class).list();
		
		logger.info("Albums retrieved : " + result.size());
		
		return result;
	}

}
