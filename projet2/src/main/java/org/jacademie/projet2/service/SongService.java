package org.jacademie.projet2.service;

import java.util.List;
import org.jacademie.projet2.domain.Chanson;


public interface SongService {
	
	public 	List<Chanson> retrieveAllSongs() 			throws Exception;

}
