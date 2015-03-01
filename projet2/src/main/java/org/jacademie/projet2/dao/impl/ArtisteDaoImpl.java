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

		Criteria criteria = this.sessionFactory.openSession().createCriteria(
				Artiste.class);

		@SuppressWarnings("unchecked")
		List<Artiste> list = criteria.list();

		Set<Artiste> result = new HashSet<Artiste>(list);

		logger.info("Out retrieveAllArtistes (DAO)");

		return result;
	}

	@Override
	public Artiste findArtisteById(Integer id) throws Exception {

		logger.info("Finding Artiste with id : " + id + "...");

		Artiste result = (Artiste) this.sessionFactory.openSession().get(
				Artiste.class, id);

		if (result != null) {

			logger.info("Artiste found : " + result);

		} else {

			logger.info("Artiste not found");

		}

		return result;
	}

	/**
	 * Persiste un Artiste en BDD.
	 * 
	 * @param Artiste
	 *            artiste : objet Artiste
	 * @throws Exception
	 */
	@Override
	public void createArtiste(Artiste artiste) throws Exception {

		logger.info("Creating artiste : " + artiste + "...");
		
		this.sessionFactory.openSession().save(artiste);

		logger.info("Artiste created. \n");

	}

	/**
	 * Efface tous les artiste en BDD.
	 * 
	 * @throws Exception
	 */
	public void deleteArtisteById(Integer id) throws Exception {
 
		logger.info("Deleting Artiste...");
		
		Artiste artiste = this.findArtisteById(id);
	
		this.sessionFactory.getCurrentSession().delete(artiste);
			
		logger.info("Artiste deleted ");
 
	}

}
