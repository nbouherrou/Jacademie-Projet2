package org.jacademie.projet2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.apache.logging.log4j.LogManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jacademie.projet2.dao.SongsDao;
import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.domain.Chanson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongsDaoImpl implements SongsDao {

	private static org.apache.logging.log4j.Logger logger = LogManager
			.getLogger(SongsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void createNewSong(Chanson song) throws Exception {
		
		logger.info("Creating a new song " + song.getTitre() + " in dao...");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(song);

		logger.info("New song created in dao !");

		tx.commit();

	}

	@Override
	public List<Chanson> findSongsByCodeArtisteCodeAlbum(Integer codeArtiste, Integer codeAlbum) throws Exception {
		
		logger.info("Finding Chansons with codeArtiste : " + codeArtiste + ", codeAlbum "+ codeAlbum + "...");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Chanson.class);
		
		criteria.add(Restrictions.eq("chansonID.albumID.idArtiste", codeArtiste));
		
		criteria.add(Restrictions.eq("chansonID.albumID.idAlbum", codeAlbum));
		
		List<Chanson> result = criteria.list();
		
		tx.commit();
		
		logger.info("findSongsByCodeArtisteCodeAlbum Result : " + result);

		if (result != null) {

			logger.info("Chansons found : " + result);

		} else {

			logger.info("Chansons not found");

		}

		return result;
	}

	@Override
	public void deleteSong(Chanson chanson) {
		
		logger.info(" Deleting song " + chanson);
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		logger.info(" Deleting session " + session);
		
		logger.info(" Deleting factory " + this.sessionFactory);
		
		session.delete(chanson);
		
		tx.commit();
		
		logger.info(" Song deleted ! ");
		
	}

	@Override
	public Chanson findSongByCodeChansonCodeArtisteCodeAlbum(
			Integer codeArtiste, Integer codeAlbum, Integer codeChanson)
			throws Exception {
		
		logger.info("Finding Song with id : " + codeArtiste + ", " + codeAlbum + ", " + codeChanson);
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Chanson.class);
		
		criteria.add(Restrictions.eq("chansonID.idChanson", codeChanson));
		
		criteria.add(Restrictions.eq("chansonID.albumID.idArtiste", codeArtiste));
		
		criteria.add(Restrictions.eq("chansonID.albumID.idAlbum", codeAlbum));
		
		Chanson result = (Chanson) criteria.uniqueResult();
		
		tx.commit();
		
		logger.info("RESULT : " + result);

		if (result != null) {

			logger.info("Artiste found : " + result);

		} else {

			logger.info("Artiste not found");

		}

		return result;
		
	}

	@Override
	public List<Chanson> findSongsByCodeAlbum(Integer codeAlbum)
			throws Exception {
		
		logger.info("Retrieving all Songs by code Album : "+codeAlbum );
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Chanson.class);
		
		criteria.add(Restrictions.eq("chansonID.albumID.idAlbum", codeAlbum));

		List<Chanson> result = criteria.list();
		
		tx.commit();
		
		logger.info("RESULT : " + result);

		if (result != null) {

			logger.info("Chanson found : " + result);

		} else {

			logger.info("Chanson not found");

		}

		return result;
	}

	@Override
	public void updateSong(Chanson chanson) {
		
		logger.info("Update Chanson " + chanson);
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.merge(chanson);
		
		tx.commit();

		logger.info("Chanson updated. \n");
		
	}

}
