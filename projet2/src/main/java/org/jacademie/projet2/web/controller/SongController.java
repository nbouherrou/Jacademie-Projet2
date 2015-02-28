package org.jacademie.projet2.web.controller;

// import java.util.List;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Chanson;
import org.jacademie.projet2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.jacademie.projet2.domain.Album;
// import org.jacademie.projet2.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SongController {
	
	private static Logger logger = LogManager.getLogger(SongController.class);

	@Autowired
	private SongService songService;
	
	@RequestMapping(value = "/Songs", method = RequestMethod.GET)
    public String displaySongs(Model model) throws Exception {

		logger.info("In displaySongs (Controller)");
		
		List<Chanson> songs = this.songService.retrieveAllSongs();
		
		// albums.forEach(e -> logger.info(e));
		
		model.addAttribute("songs", songs);

		logger.info("Out displaySongs (Controller)");
		
		return "songs";
    }
	
}
