package org.jacademie.projet2.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.dao.ArtisteDao;
import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtisteServiceImpl implements ArtisteService {
	
	private static Logger logger = LogManager.getLogger(ArtisteServiceImpl.class);
	
	@Autowired
	private ArtisteDao artisteDao;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Artiste> retrieveAllArtistes() {
		
		logger.info("In retrieveAllArtistes (Service)");
		
		ArrayList<Artiste> list = new ArrayList<Artiste>(artisteDao.retrieveAllArtistes());
		
		Collections.sort(list, new Comparator<Artiste>(){
			
			public int compare(Artiste a1, Artiste a2){
	 
				return a1.getIdArtiste().compareTo(a2.getIdArtiste());
	 
			}
	 
		});
		
		logger.info("Out of retrieveAllArtistes (Service)");
		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public Artiste findArtisteByCodeArtiste(Integer codeArtiste) throws Exception {
		
		return this.artisteDao.findArtisteByCodeArtiste(codeArtiste);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void createArtiste(Artiste artiste) throws Exception {
		
		this.artisteDao.createArtiste(artiste);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteArtiste(Artiste artiste) throws Exception{;
		
		this.artisteDao.deleteArtiste(artiste);
 
	}

}
