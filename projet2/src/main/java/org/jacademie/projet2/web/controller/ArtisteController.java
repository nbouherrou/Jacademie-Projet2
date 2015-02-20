package org.jacademie.projet2.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtisteController {
	
	private static Logger logger = LogManager.getLogger(ArtisteController.class);

	@Autowired
	private ArtisteService artisteService;
	
	@RequestMapping(value = "/Artistes", method = RequestMethod.GET)
    public String displayArtistes(Model model) {

		logger.info("In displayArtistes (Controller)");
		
		model.addAttribute("artistes", this.artisteService.retrieveAllArtistes());
		
		logger.info("Out displayArtistes (Controller)");
		
		return "artistes";
    }
	
}
