package org.jacademie.projet2.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.jacademie.projet2.dao.SongsDao;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.Chanson;
import org.jacademie.projet2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "songService")
public class SongServiceImpl implements SongService {

	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(SongServiceImpl.class);

	@Autowired
	private SongsDao songsDao;


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createNewSong(Chanson song) throws Exception {

		logger.info("creating new song " + song.getTitre()
				+ " in songService...");

		this.songsDao.createNewSong(song);

		logger.info("new song created in songService !");

	}
	@Override
	@Transactional(readOnly=true)
	public List<Chanson> findSongsByCodeArtisteCodeAlbum(Integer codeArtiste, Integer codeAlbum) throws Exception {

		return this.songsDao.findSongsByCodeArtisteCodeAlbum(codeArtiste,codeAlbum);
	}

	@Override
	@Transactional
	public void deleteSong(Chanson chanson) throws Exception {
	
		this.songsDao.deleteSong( chanson);
		
	}

	@Override
	@Transactional
	public Chanson findSongByCodeChansonCodeArtisteCodeAlbum(
			Integer codeArtiste, Integer codeAlbum, Integer codeChanson)
			throws Exception {
		
		return this.songsDao.findSongByCodeChansonCodeArtisteCodeAlbum(codeArtiste, codeAlbum, codeChanson);
	}

	@Override
	public List<Chanson> findSongsByCodeAlbum(Integer codeAlbum) throws Exception{
		return this.songsDao.findSongsByCodeAlbum(codeAlbum);
	}

	@Override
	public void updateSong(Chanson chanson) {
		
		this.songsDao.updateSong(chanson);
		
	}

}
