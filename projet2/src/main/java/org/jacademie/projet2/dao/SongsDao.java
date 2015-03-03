package org.jacademie.projet2.dao;

import java.util.List;

import org.jacademie.projet2.domain.Chanson;

public interface SongsDao {
	
	public 	List<Chanson> retrieveAllSongs() 						throws Exception;
	
	public 	List<Chanson> findSongsByCodeArtisteCodeAlbum(Integer codeArtiste, Integer codeAlbum) 		throws Exception;
	
	public 	void createNewSong( Chanson song ) 						throws Exception;

}
