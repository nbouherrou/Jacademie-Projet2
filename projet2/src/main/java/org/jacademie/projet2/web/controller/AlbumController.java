package org.jacademie.projet2.web.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.projet2.domain.Album;
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

/*
 * Controller Album
 */
@Controller
public class AlbumController {

	private static Logger logger = LogManager.getLogger(AlbumController.class);

	/*
	 * Service Album
	 */
	@Autowired
	private AlbumService albumService;

	/*
	 * Service Artiste
	 */
	@Autowired
	private ArtisteService artisteService;

	/*
	 * Service Song
	 */
	@Autowired
	private SongService songService;

	/*
	 * Recupère les albums associé à un Artiste et initialise le formulaire
	 * 
	 * @param : Integer id
	 */
	@RequestMapping(value = "/Albums", method = RequestMethod.GET)
	public String findAlbumsbyArtisteId(@RequestParam("id") Integer id,
			Model model) throws Exception {

		model.addAttribute("id", id);

		model.addAttribute("Album", new Album());

		model.addAttribute("albums", albumService.findAlbumsByCodeArtiste(id));

		return "albums";

	}

	/*
	 * Ajoute un album en bdd et rinitialise la vue
	 * 
	 * @param : Album album
	 */
	@RequestMapping(value = "/AddAlbum", method = RequestMethod.POST)
	public String addAlbum(@Valid @ModelAttribute("Album") Album album,
			BindingResult result, ModelMap model) {

		logger.info("form control reached !");

		logger.info(album.toString());

		try {

			logger.info("album persisting...");

			this.albumService.createAlbum(album);

			logger.info("album persisted ! ");

			model.addAttribute("albums", albumService
					.findAlbumsByCodeArtiste(album.getAlbumID().getIdArtiste()));

		} catch (Exception e) {

			e.printStackTrace();
		}

		logger.info("form control treated !");

		return "albums";

	}

	/*
	 * Initialise le formulaire d'edition d'un album
	 * 
	 * @param : Integer codeArtiste Integer codeAlbum
	 */
	@RequestMapping(value = "/updateAlbum", method = RequestMethod.GET)
	public String updateAlbum(@RequestParam("codeArtiste") Integer codeArtiste,
			@RequestParam("codeAlbum") Integer codeAlbum, Model model)
			throws Exception {

		model.addAttribute("Album", this.albumService
				.findAlbumByCodeArtisteCodeAlbum(codeArtiste, codeAlbum));

		return "album-edit";

	}

	/*
	 * Traite l'objet modifié et le traite en bdd
	 * 
	 * @param : Album album
	 */
	@RequestMapping(value = "/AlbumToUpdate", method = RequestMethod.POST)
	public String updateAlbum(@Valid @ModelAttribute("Album") Album album,
			BindingResult result, ModelMap model) throws Exception {

		this.albumService.updateAlbum(album);

		model.addAttribute("albums", albumService.findAlbumsByCodeArtiste(album
				.getAlbumID().getIdArtiste()));

		return "albums";

	}

}
