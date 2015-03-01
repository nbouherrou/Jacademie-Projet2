package org.jacademie.projet2.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.service.AlbumService;
import org.jacademie.projet2.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {
	
	private static Logger logger = LogManager.getLogger(AlbumController.class);

	@Autowired
	private 	AlbumService 	albumService;
	
	@Autowired
	private 	ArtisteService 	artisteService;
	
	@RequestMapping(value = "/AlbumsListe", method = RequestMethod.GET)
    public String displayAlbums(Model model) throws Exception {

		logger.info("In displayAlbums (Controller)");
		
		List<Album> albums = this.albumService.retrieveAllAlbums();
		
		albums.forEach(e -> logger.info(e));
		
		model.addAttribute("albums", albums);

		logger.info("Out displayAlbums (Controller)");
		
		return "albums";
    }
	
	@RequestMapping(value = "/Albums", method = RequestMethod.GET)
    public String displayArtisteAlbums(@RequestParam("id") Integer id, Model model) throws Exception {

		logger.info("In displayArtisteAlbums (Controller)");
		
		logger.info("Artiste id = " + id);
		
		Artiste artiste = artisteService.findArtisteById(id);
		
		model.addAttribute("albums", artiste.getAlbums());
		
		artiste.getAlbums().forEach(e -> logger.info(e));

		logger.info("Out displayArtisteAlbums (Controller)");
		
		return "albums";
    }
	
}
