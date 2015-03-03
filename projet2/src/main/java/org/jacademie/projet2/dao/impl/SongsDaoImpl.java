package org.jacademie.projet2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jacademie.projet2.dao.SongsDao;
import org.jacademie.projet2.domain.Album;
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
		
		Session session = this.sessionFactory.openSession();
		
		result = session.createCriteria(Chanson.class).list();
		
		logger.info("Albums retrieved : " + result.size());
		
		session.close();
		
		return result;
	}
	
	@Override
	public void createNewSong(Chanson song) throws Exception {
		
		logger.info("Creating a new song " + song.getTitre() + " in dao...");
		
		Session session = this.sessionFactory.openSession();

		session.save(song);

		logger.info("New song created in dao !");

		session.close();

		
	}

	@Override
	public List<Chanson> findSongsByCodeArtisteCodeAlbum(Integer codeArtiste, Integer codeAlbum) throws Exception {
		
		logger.info("Finding Chansons with codeArtiste : " + codeArtiste + ", codeAlbum "+ codeAlbum + "...");
		
		Session session = this.sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Chanson.class);
		
		criteria.add(Restrictions.eq("chansonID.albumID.idArtiste", codeArtiste));
		
		criteria.add(Restrictions.eq("chansonID.albumID.idAlbum", codeAlbum));
		
		List<Chanson> result = criteria.list();
		
		logger.info("findSongsByCodeArtisteCodeAlbum Result : " + result);

		if (result != null) {

			logger.info("Chansons found : " + result);

		} else {

			logger.info("Chansons not found");

		}
		
		session.close();

		return result;
	}

}
