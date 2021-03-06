package org.jacademie.projet2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jacademie.projet2.dao.AlbumDao;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.AlbumId;
import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.domain.Chanson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumDaoImpl implements AlbumDao {

	private static org.apache.logging.log4j.Logger logger = LogManager
			.getLogger(AlbumDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createAlbum(Album album) throws Exception {

		logger.info("Creating Album : " + album + "...");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(album);
		
		tx.commit();

		logger.info("Album created. \n");
	}


	@Override
	public void updateAlbum(Album album) throws Exception {
				
		logger.info("Updating Album : " + album + "...");

		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.merge(album);
		
		tx.commit();

		logger.info("Album updated. \n");

	}


	@Override
	public List<Album> findAlbumsByCodeArtiste(Integer codeArtiste) throws Exception {
		
		logger.info("Finding Albums with codeArtiste : " + codeArtiste + "...");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Album.class);
		
		criteria.add(Restrictions.eq("albumID.idArtiste", codeArtiste));
		
		List<Album> result = criteria.list();
		
		tx.commit();
		
		logger.info("findAlbumsByCodeArtiste Result : " + result);

		if (result != null) {

			logger.info("Albums found : " + result);

		} else {

			logger.info("Albums not found");

		}

		return result;

	}


	@Override
	public void deleteAlbum(Album album) {
		
		logger.info("Deleting album " + album + " ...");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();

		session.delete(album);
		
		tx.commit();
		
		logger.info("Album deleted");
		
	}


	@Override
	public Album findAlbumByCodeArtisteCodeAlbum(Integer codeArtiste,
			Integer codeAlbum) {
		
		logger.info("Finding Album with codeArtiste : " + codeArtiste + ", codeAlbum : " + codeAlbum + " ... ");
		
		Session session = this.sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Album.class);
		
		criteria.add(Restrictions.eq("albumID.idArtiste", codeArtiste));
		
		criteria.add(Restrictions.eq("albumID.idAlbum", codeAlbum));
		
		Album result = (Album) criteria.uniqueResult();
		
		logger.info("RESULT : " + result);

		if (result != null) {

			logger.info("Album found : " + result);

		} else {

			logger.info("Album not found");

		}
		
		session.getTransaction().commit();

		return result;
		
	}

}
