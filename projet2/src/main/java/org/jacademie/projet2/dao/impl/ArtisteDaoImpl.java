package org.jacademie.projet2.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Artiste.class);

		List<Artiste> list = criteria.list();
		
		tx.commit();

		Set<Artiste> result = new HashSet<Artiste>(list);

		logger.info("Out retrieveAllArtistes (DAO)");

		return result;
	}
	
	@Override
	public Artiste findArtisteByCodeArtiste(Integer codeArtiste) throws Exception {

		logger.info("Finding Artiste with id : " + codeArtiste + "...");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Artiste.class);
		
		criteria.add(Restrictions.eq("idArtiste", codeArtiste));
		
		Artiste result = (Artiste) criteria.uniqueResult();
		
		tx.commit();
		
		logger.info("RESULT : " + result);

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

		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.save(artiste);
		
		tx.commit();

		logger.info("Artiste created. \n");

	}

	@Override
	public void deleteArtiste(Artiste artiste) throws Exception {
		
		logger.info("Delete Artist " + artiste);
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.delete(artiste);
		
		tx.commit();

		logger.info("Artiste deleted. \n");
		
	}

	@Override
	public void updateArtiste(Artiste artiste) {
		
		logger.info("Update Artist " + artiste);
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.merge(artiste);
		
		tx.commit();

		logger.info("Artiste updated. \n");
		
	}

}
