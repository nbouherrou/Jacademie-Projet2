package org.jacademie.projet2.dao;

import java.util.List;

import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.AlbumId;

public interface AlbumDao {
	
	public 	void 		createAlbum(Album album) 		throws Exception;
	
	public 	List<Album> findAlbumsByCodeArtiste(Integer codeArtiste) 	throws Exception;
	
	public 	Album 		findAlbumById(AlbumId albumID) 	throws Exception;
	
	public 	void 		updateAlbum(Album album) 		throws Exception;
	
	public 	List<Album> retrieveAllAlbums() 			throws Exception;
	
	public 	void 		deleteAllAlbums() 				throws Exception;

}
