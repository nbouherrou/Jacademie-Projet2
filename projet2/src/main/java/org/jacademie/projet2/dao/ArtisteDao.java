package org.jacademie.projet2.dao;

import java.util.Collection;

import javax.transaction.Transactional;

import org.jacademie.projet2.domain.Artiste;


public interface ArtisteDao {

	/**
	 * Recupère la liste des artistes en BDD
	 * 
	 * @return		Collection<Artiste>
	 */
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
	 * Efface un artiste de la BDD
	 * 
	 * @param 	Artiste		artiste		: objet Artiste
	 * @throws Exception
	 */
	public void deleteArtiste(Artiste artiste) throws Exception;
	
	/**
	 * Update un artiste en BDD
	 * 
	 * @param 	Artiste		artiste		: objet Artiste
	 */
	public void updateArtiste(Artiste artiste);
	
	
}
