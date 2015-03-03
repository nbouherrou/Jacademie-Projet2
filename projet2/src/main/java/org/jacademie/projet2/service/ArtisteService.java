package org.jacademie.projet2.service;

import java.util.Collection;

import org.jacademie.projet2.domain.Artiste;

public interface ArtisteService {
	
	public Collection<Artiste> retrieveAllArtistes();
	
	/**
	 * Recupère un objet Artiste de la BDD à partir de son identifiant.
	 * 
	 * @param 		int id		: identifiant de l'artiste
	 * @return		Artiste
	 * @throws 		Exception
	 */
	public Artiste findArtisteByCodeArtiste(Integer codeArtiste) throws Exception;
	
	
	/**
	 * Persiste un Artiste en BDD.
	 * 
	 * @param 	Artiste		artiste		: objet Artiste
	 * @throws 	Exception
	 */
	public void createArtiste(Artiste artiste) throws Exception;

	/**
	 * Efface l'artiste en BDD.
	 * 
	 * @throws Exception
	 */
	public void deleteArtisteById(Integer id) throws Exception;
}
