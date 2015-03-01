package org.jacademie.projet2.web.controller;

// import java.util.List;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Chanson;
import org.jacademie.projet2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.jacademie.projet2.domain.Album;
// import org.jacademie.projet2.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
	
	private static Logger logger = LogManager.getLogger(SongController.class);

	@Autowired
	private SongService songService;
	
	@RequestMapping( value = "/Songs", method = RequestMethod.GET )
    public String displaySongs(Model model) throws Exception {

		logger.info("In displaySongs (Controller)");
		
		List<Chanson> songs = this.songService.retrieveAllSongs();
		
		model.addAttribute("songs", songs);

		logger.info("Out displaySongs (Controller)");
		
		return "songs";
    }
	
	@RequestMapping(value = "/SongForm", method = RequestMethod.GET)
	public ModelAndView sendSong( ) throws Exception {
	     
		return new ModelAndView( "songForm", "command", new Chanson() );
		
	}
	
	@RequestMapping(value = "/AddSong", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("Chanson") Chanson song, BindingResult result, ModelMap model) {
	      
		logger.info( "form control reached !" );
	      
		model.addAttribute("titre", 		song.getTitre());
	      
		model.addAttribute("dureeChanson", 	song.getDureeChanson());
	      
		logger.info( "form control treated !" );
		
		return "songResult";
		
	}
		
}
