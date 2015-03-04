package org.jacademie.projet2.service;

import java.util.List;

import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.AlbumId;

public interface AlbumService {
	
	/**
	 * Persiste un Album en BDD.
	 * 
	 * @param 		Album	album		: Objet Album
	 * @throws 		Exception
	 */
	public 	void 		createAlbum(Album album) 		throws Exception;
	
	/**
	 * Recupère la liste des albums d'un artiste suivant son codeArtiste
	 * 
	 * @param 		Integer codeArtiste
	 * @return		List<Album>
	 * @throws 		Exception
	 */
	public 	List<Album> findAlbumsByCodeArtiste(Integer codeArtiste) 	throws Exception;
	
	/**
	 * Met à jour les données (enfants aussi, Chansons) d'un objet Album en les persistant en BDD.
	 * 
	 * @param 	Album	album		: objet album
	 * @throws 	Exception
	 */
	public 	void 		updateAlbum(Album album) 		throws Exception;
	
	/**
	 * Efface un  album de la BDD.
	 * 
	 * @throws 	Exception
	 */
	public	void 		deleteAlbum(Album album);

	/**
	 * Recupère un album suivant son codeAlbum et son codeArtiste
	 * 
	 * @param 		Integer codeArtiste
	 * @param 		Integer codeAlbum
	 * @return		Album
	 */
	public 	Album 	findAlbumByCodeArtisteCodeAlbum(Integer codeArtiste, Integer codeAlbum);
	
}
