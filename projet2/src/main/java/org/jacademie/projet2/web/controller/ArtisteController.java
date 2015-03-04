package org.jacademie.projet2.web.controller;

import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.Artiste;
import org.jacademie.projet2.domain.Chanson;
import org.jacademie.projet2.service.AlbumService;
import org.jacademie.projet2.service.ArtisteService;
import org.jacademie.projet2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtisteController {
	
	private static Logger logger = LogManager.getLogger(ArtisteController.class);

	@Autowired
	private ArtisteService artisteService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private SongService songService;
	
	@RequestMapping(value = "/Artistes", method = RequestMethod.GET)
    public String displayArtistes(Model model) {

		logger.info("In displayArtistes (Controller)");
		
		model.addAttribute("artistes", this.artisteService.retrieveAllArtistes());
		
		logger.info("Out displayArtistes (Controller)");
		
		return "artistes";
    }
	
	@RequestMapping(value ="/registerArtiste", method = RequestMethod.POST)
    public ModelAndView submitFormArtiste(@RequestParam("codeArtiste") String codeArtiste, @RequestParam("name") String artiste) {
		
		logger.info("Artiste POST : " + codeArtiste.toString() + "  "+ artiste.toString() );
		
		
		Artiste art = new Artiste();
		art.setNom(artiste);
		art.setIdArtiste(Integer.parseInt(codeArtiste));
	
		try {
			
			this.artisteService.createArtiste(art);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:Artistes.do");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteArtiste", method = RequestMethod.GET)
    public ModelAndView deleteArtiste(@RequestParam(value="codeArtiste") Integer codeArtiste) {
		
		logger.info("In deleteArtiste (Controller)");
		
		try {
			
			Artiste artiste = this.artisteService.findArtisteByCodeArtiste(codeArtiste);
			
			artiste.setAlbums((Set<Album>) this.albumService.findAlbumsByCodeArtiste(codeArtiste));
			
			for( Album album : artiste.getAlbums()){
				
				/*
				for(Chanson chanson : album.getChansons()){
					
					this.songService.deleteSong(chanson);
				
				}
				*/
				
				this.albumService.deleteAlbum(album);
			}
			
			this.artisteService.deleteArtiste(artiste);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		logger.info("Out deleteArtiste (Controller)");
		
		return new ModelAndView("redirect:Artistes.do");
	}
	
	@RequestMapping(value = "/updateArtiste", method = RequestMethod.GET)
	public String updateArtiste( @RequestParam("codeArtiste") Integer codeArtiste, Model model ) throws Exception {
	     		
		model.addAttribute( "Artiste", this.artisteService.findArtisteByCodeArtiste(codeArtiste) );
		
		return "artiste-edit";
		
	}
	
	@RequestMapping(value = "/ArtisteToUpdate", method = RequestMethod.POST)
	public String updateArtiste( @Valid @ModelAttribute("Artiste") Artiste artiste, BindingResult result, ModelMap model ) throws Exception {
	     		
		this.artisteService.updateArtiste(artiste);
		
		model.addAttribute("artistes", this.artisteService.retrieveAllArtistes());
		
		return "artistes";
		
	}
	
	
}