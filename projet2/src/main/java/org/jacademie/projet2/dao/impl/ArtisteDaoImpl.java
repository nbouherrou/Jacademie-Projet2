package org.jacademie.projet2.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.jacademie.projet2.dao.ArtisteDao;
import org.jacademie.projet2.domain.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ArtisteDaoImpl implements ArtisteDao {
	
	private static Logger logger = LogManager.getLogger(ArtisteDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Set<Artiste> retrieveAllArtistes() {
		
		logger.info("In retrieveAllArtistes (DAO)");
		
		Criteria criteria = this.sessionFactory.openSession().createCriteria(Artiste.class);
		
		@SuppressWarnings("unchecked")
		List<Artiste> list = criteria.list();
		
		Set<Artiste> result = new HashSet<Artiste>(list);
		
		logger.info("Out retrieveAllArtistes (DAO)");
		
		return result;
	}

	
}
