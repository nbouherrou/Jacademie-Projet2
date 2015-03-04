package org.jacademie.projet2.web.controller;

// import java.util.List;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Album;
import org.jacademie.projet2.domain.Chanson;
import org.jacademie.projet2.service.SongService;
import org.jacademie.projet2.service.impl.SongServiceImpl;
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
public class SongController {
	
	private static Logger logger = LogManager.getLogger(SongController.class);

	@Autowired
	private SongService songService;

	// http://localhost:8080/projet2/Songs.do
	
	@RequestMapping( value = "/Songs", method = RequestMethod.GET )
    public String displaySongs(@RequestParam("codeArtiste") Integer codeArtiste, @RequestParam("codeAlbum") Integer codeAlbum, Model model) throws Exception {

		logger.info("In displaySongs (Controller)");
		
		model.addAttribute( "Chanson", new Chanson() );
		
		model.addAttribute("codeArtiste", 	codeArtiste);
		
		model.addAttribute("codeAlbum", 	codeAlbum);
		
		model.addAttribute("songs", 	this.songService.findSongsByCodeArtisteCodeAlbum(codeArtiste, codeAlbum));
		
		return "songs";
    }

	// http://localhost:8080/projet2/SongForm.do
	
	@RequestMapping(value = "/SongForm", method = RequestMethod.GET)
	public ModelAndView sendSong( ) throws Exception {
	     
		return new ModelAndView( "songForm", "command", new Chanson() );
		
	}
	
	@RequestMapping(value = "/SongFormCreation", method = RequestMethod.GET)
	public ModelAndView sendBlankSong( ) throws Exception {
	     
		return new ModelAndView( "songFormCreation", "command", new Chanson() );
		
	}

	// http://localhost:8080/projet2/AddSong.do
	
	@RequestMapping(value = "/AddSong", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("Chanson") Chanson song, BindingResult result, ModelMap model) {
	      
		logger.info( "form control reached !" );
	    
		logger.info("chanson to be added " + song);
		
		try {
			
			this.songService.createNewSong(song);
			
			Integer codeArtiste = song.getChansonID().getAlbumID().getIdArtiste();
			
			Integer codeAlbum   = song.getChansonID().getAlbumID().getIdAlbum();
			
			model.addAttribute("codeArtiste", 	codeArtiste);
			
			model.addAttribute("codeAlbum", 	codeAlbum);
			
			model.addAttribute("songs", 	this.songService.findSongsByCodeArtisteCodeAlbum(codeArtiste, codeAlbum));
			
			//TEST
			logger.info("TEST findSongsByCodeAlbum ");
			
			logger.info(this.songService.findSongsByCodeAlbum(codeAlbum));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	      
		logger.info( "form control treated !" );
		
		return "songs";
		
	}
	
	// http://localhost:8080/projet2/CreateNewSong.do
	
	@RequestMapping(value = "/CreateNewSong", method = RequestMethod.POST)
	public String createNewSong(@Valid @ModelAttribute("Chanson") Chanson song, BindingResult result, ModelMap model) {
	      
		logger.info( "form control reached !" );
	    
		model.addAttribute("idChanson", 	song.getChansonID().getIdChanson());
		
		model.addAttribute("idAlbum", 		song.getChansonID().getAlbumID().getIdAlbum());
		
		model.addAttribute("idArtiste", 	song.getChansonID().getAlbumID().getIdArtiste());
		
		model.addAttribute("titre", 		song.getTitre());
	      
		model.addAttribute("dureeChanson", 	song.getDureeChanson());
	    
		SongServiceImpl songServiceImpl = new SongServiceImpl();
		
		try {
			
			logger.info( "song persisting ..." );
			
			songServiceImpl.createNewSong( song );
			
			logger.info( "song persisted !" );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		logger.info( "form control treated !" );
		
		return "songResultCreation";
		
	}
	
	
	@RequestMapping( value = "/DeleteSong", method = RequestMethod.GET )
    public ModelAndView deleteSong(@RequestParam("codeArtiste") Integer codeArtiste, @RequestParam("codeAlbum") Integer codeAlbum, @RequestParam("codeChanson") Integer codeChanson, Model model) throws Exception {

		logger.info("In displaySongs (Controller)");
		
		this.songService.deleteSong(this.songService.findSongByCodeChansonCodeArtisteCodeAlbum(codeArtiste, codeAlbum, codeChanson));
		
		String url = "redirect:Songs.do?codeArtiste="+codeArtiste+"&codeAlbum="+codeAlbum;
		
		return new ModelAndView(url);
    }

		
}
