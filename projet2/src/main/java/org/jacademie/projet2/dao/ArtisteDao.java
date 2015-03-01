package org.jacademie.projet2.dao;

import java.util.Collection;

import org.jacademie.projet2.domain.Artiste;


public interface ArtisteDao {

	public Collection<Artiste> retrieveAllArtistes();
	
	/**
	 * Recupère un objet Artiste de la BDD à partir de son identifiant.
	 * 
	 * @param 		int id		: identifiant de l'artiste
	 * @return		Artiste
	 * @throws 		Exception
	 */
	public Artiste findArtisteById(int id) throws Exception;
	
	
}
