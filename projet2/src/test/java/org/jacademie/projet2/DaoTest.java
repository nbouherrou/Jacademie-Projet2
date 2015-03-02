package org.jacademie.projet2;

import java.util.HashSet;

import junit.framework.Assert;

import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.service.AlbumService;
import org.jacademie.projet2.service.ArtisteService;
import org.jacademie.projet2.service.SongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:AppContextTestConfig.xml" })
public class DaoTest {
	
	@Autowired
	private 	AlbumService 	albumService;
	
	@Autowired
	private 	ArtisteService 	artisteService;

	@Autowired
	private 	SongService 	songService;
	
	

	@Test
	public void createArtisteTest() throws Exception {
		
		this.artisteService.createArtiste(new Artiste(33, "POP4", new HashSet<Album>()));
		
		Artiste art2 = this.artisteService.findArtisteById(33);
		
		Assert.assertEquals((Integer) 33,  art2.getIdArtiste());
		
	}
	
	@Test
	public void ArtisteNumber() throws Exception {
		
		Assert.assertEquals(0,  this.artisteService.retrieveAllArtistes().size());
		
	}
	

}
