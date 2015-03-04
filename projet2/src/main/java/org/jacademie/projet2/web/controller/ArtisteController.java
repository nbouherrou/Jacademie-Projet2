package org.jacademie.projet2.web.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Artiste;
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

/**
 * Controller Artiste
 */
@Controller
public class ArtisteController {

	private static Logger logger = LogManager
			.getLogger(ArtisteController.class);

	/**
	 * Service Artiste
	 */
	@Autowired
	private ArtisteService artisteService;

	/**
	 * Service Album
	 */
	@Autowired
	private AlbumService albumService;

	/**
	 * Service Song
	 */
	@Autowired
	private SongService songService;

	/**
	 * Récupère tous les artistes de la bdd
	 */
	@RequestMapping(value = "/Artistes", method = RequestMethod.GET)
	public String displayArtistes(Model model) {

		logger.info("In displayArtistes (Controller)");

		model.addAttribute("artistes",
				this.artisteService.retrieveAllArtistes());

		logger.info("Out displayArtistes (Controller)");

		return "artistes";
	}

	/**
	 * Enregistrement d'un artiste en bdd
	 * 
	 * @param   String codeArtiste 
	 * @param   String nom
	 */
	@RequestMapping(value = "/registerArtiste", method = RequestMethod.POST)
	public ModelAndView submitFormArtiste(
			@RequestParam("codeArtiste") String codeArtiste,
			@RequestParam("name") String artiste) {

		logger.info("Artiste POST : " + codeArtiste.toString() + "  "
				+ artiste.toString());

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

	/**
	 * Initialise le formulaire d'edition d'un artiste
	 * 
	 * @param : Integer codeArtiste
	 */
	@RequestMapping(value = "/updateArtiste", method = RequestMethod.GET)
	public String updateArtiste(
			@RequestParam("codeArtiste") Integer codeArtiste, Model model)
			throws Exception {

		model.addAttribute("Artiste",
				this.artisteService.findArtisteByCodeArtiste(codeArtiste));

		return "artiste-edit";

	}

	/**
	 * Traite l'objet modifié et le traite en bdd
	 * 
	 * @param : Artiste artiste
	 */
	@RequestMapping(value = "/ArtisteToUpdate", method = RequestMethod.POST)
	public String updateArtiste(
			@Valid @ModelAttribute("Artiste") Artiste artiste,
			BindingResult result, ModelMap model) throws Exception {

		this.artisteService.updateArtiste(artiste);

		model.addAttribute("artistes",
				this.artisteService.retrieveAllArtistes());

		return "artistes";

	}

}