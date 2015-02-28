package org.jacademie.projet2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.hibernate.SessionFactory;
import org.jacademie.projet2.dao.AlbumDao;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.AlbumId;
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

		this.sessionFactory.getCurrentSession().save(album);

		logger.info("Album created. \n");
	}

	
	@Override
	public Album findAlbumById(AlbumId albumID) throws Exception {
		
		logger.info("Finding Album with id : " + albumID + "...");

		Album result = (Album) this.sessionFactory.getCurrentSession().get(Album.class, albumID);

		if (result != null) {

			logger.info("Album found : " + result);
			
		} else {
			
			logger.info("Album not found");
			
		}

		return result;
	}

	@Override
	public void updateAlbum(Album album) throws Exception {
		
		logger.info("Updating Album : " + album + "...");

		this.sessionFactory.getCurrentSession().merge(album);

		logger.info("Album updated. \n");

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> retrieveAllAlbums() throws Exception {
		
		logger.info("Retrieving all Albums ...");
		
		List<Album> result = new ArrayList<Album>();

		result = this.sessionFactory.getCurrentSession().createCriteria(Album.class).list();

		logger.info("Albums retrieved : " + result.size());

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllAlbums() throws Exception {
		
		logger.info("Deleting all Albums...");
		
		this.sessionFactory.getCurrentSession().createCriteria(Album.class).list().forEach(element -> {
			
			this.sessionFactory.getCurrentSession().delete(element);
			
		});
		
		logger.info("Albums deleted ");

	}

}
