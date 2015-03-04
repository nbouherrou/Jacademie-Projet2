package org.jacademie.projet2.dao;

import java.util.Collection;

import javax.transaction.Transactional;

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
	public Artiste findArtisteByCodeArtiste(Integer codeArtiste) throws Exception;
	
	
	/**
	 * Persiste un Artiste en BDD.
	 * 
	 * @param 	Artiste		artiste		: objet Artiste
	 * @throws 	Exception
	 */
	public void createArtiste(Artiste artiste) throws Exception;
	
	/**
	 * Efface tous les artiste en BDD.
	 * 
	 * @throws Exception
	 */
	public void deleteArtiste(Artiste artiste) throws Exception;
	
	
	
	public void updateArtiste(Artiste artiste);
	
	
}
