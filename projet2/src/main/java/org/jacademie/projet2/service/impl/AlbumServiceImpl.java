package org.jacademie.projet2.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.jacademie.projet2.dao.AlbumDao;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.AlbumId;
import org.jacademie.projet2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="albumService")
public class AlbumServiceImpl implements AlbumService{
	
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(AlbumServiceImpl.class);
	
	@Autowired
	private AlbumDao albumDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void createAlbum(Album album) throws Exception {
		
		this.albumDao.createAlbum(album);

	}

	@Override
	public void updateAlbum(Album album) throws Exception {
		
		this.albumDao.updateAlbum(album);
		
	}


	@Override
	public List<Album> findAlbumsByCodeArtiste(Integer codeArtiste)
			throws Exception {
			
		return this.albumDao.findAlbumsByCodeArtiste(codeArtiste);
	}

	@Override
	@Transactional
	public void deleteAlbum(Album album) {
		
		this.albumDao.deleteAlbum(album);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Album findAlbumByCodeArtisteCodeAlbum(Integer codeArtiste,Integer codeAlbum) {
		
		return this.albumDao.findAlbumByCodeArtisteCodeAlbum(codeArtiste, codeAlbum);
		
	}

}
