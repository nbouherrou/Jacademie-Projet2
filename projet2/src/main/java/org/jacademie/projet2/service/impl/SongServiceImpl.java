package org.jacademie.projet2.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.jacademie.projet2.dao.SongsDao;
import org.jacademie.projet2.dao.impl.SongsDaoImpl;
import org.jacademie.projet2.domain.Chanson;
import org.jacademie.projet2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="songService")
public class SongServiceImpl implements SongService{
	
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(SongServiceImpl.class);
	
	@Autowired
	private SongsDao songsDao;

	@Override
	@Transactional( propagation = Propagation.REQUIRED )
	public List<Chanson> retrieveAllSongs() throws Exception {
		
		logger.info( "Retrieving all songs ..." );
		
		return this.songsDao.retrieveAllSongs();
		
	}

	@Override
	@Transactional( propagation = Propagation.REQUIRED )
	public void createNewSong(Chanson song) throws Exception {
		
//		if ( this.songsDao == null ) {
//			
//			logger.info( "songDao is null ..." );
//			
//		} else {
			
			// this.songsDao = new SongsDaoImpl();
		
			logger.info( "creating new song " + song.getTitre() + " in songService..." );
			
			this.songsDao.createNewSong( song );
			
			logger.info( "new song created in songService !" );
			
//		}
		
	}

}
