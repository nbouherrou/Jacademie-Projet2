package org.jacademie.projet2.dao;

import java.util.List;

import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.domain.Chanson;

public interface SongsDao {

	/**
	 * Récupère les chansons d'un album suivant un artiste
	 * 
	 * @param Integer
	 *            codeAlbum
	 * @param Integer
	 *            codeArtiste
	 * @return List<Chanson>
	 * @throws Exception
	 */
	public List<Chanson> findSongsByCodeArtisteCodeAlbum(Integer codeArtiste,
			Integer codeAlbum) throws Exception;

	/**
	 * Récupère une chanson suivant son codeArtiste, codeAlbum, codeChanson
	 * 
	 * @param Integer
	 *            codeArtiste
	 * @param Integer
	 *            codeAlbum
	 * @param Integer
	 *            codeChanson
	 * @throws Exception
	 */
	public Chanson findSongByCodeChansonCodeArtisteCodeAlbum(
			Integer codeArtiste, Integer codeAlbum, Integer codeChanson)
			throws Exception;

	/**
	 * Crée une chanson en BDD
	 * 
	 * @param Chanson
	 *            song
	 * @throws Exception
	 */
	public void createNewSong(Chanson song) throws Exception;

	/**
	 * Supprime une chanson de la BDD
	 * 
	 * @param Chanson
	 *            chanson
	 * @throws Exception
	 */
	public void deleteSong(Chanson chanson) throws Exception;

	/**
	 * Récupère les chansons d'un album
	 * 
	 * @param Integer
	 *            codeAlbum
	 * @return List<Chanson>
	 * @throws Exception
	 */
	public List<Chanson> findSongsByCodeAlbum(Integer codeAlbum)
			throws Exception;

	/**
	 * Met à jour un chanson en BDD
	 * 
	 * @param Chanson
	 *            chanson
	 */
	public void updateSong(Chanson chanson);

}
