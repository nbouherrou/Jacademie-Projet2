package org.jacademie.projet2.web.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * Controller Song
 */
@Controller
public class SongController {

	private static Logger logger = LogManager.getLogger(SongController.class);

	/***
	 * Service Song
	 */
	@Autowired
	private SongService songService;

	/**
	 * Récupère les chansons associé à un Artiste et un Album
	 * 
	 * @param : Integer codeArtiste Integer codeAlbum
	 */
	@RequestMapping(value = "/Songs", method = RequestMethod.GET)
	public String displaySongs(
			@RequestParam("codeArtiste") Integer codeArtiste,
			@RequestParam("codeAlbum") Integer codeAlbum, Model model)
			throws Exception {

		logger.info("In displaySongs (Controller)");

		model.addAttribute("Chanson", new Chanson());

		model.addAttribute("codeArtiste", codeArtiste);

		model.addAttribute("codeAlbum", codeAlbum);

		model.addAttribute("songs", this.songService
				.findSongsByCodeArtisteCodeAlbum(codeArtiste, codeAlbum));

		return "songs";
	}

	/**
	 * Creation d'une nouvelle Chanson via le formulaire
	 * 
	 * @param Chanson song
	 */
	@RequestMapping(value = "/AddSong", method = RequestMethod.POST)
	public String addSong(@Valid @ModelAttribute("Chanson") Chanson song,
			BindingResult result, ModelMap model) {

		logger.info("form control reached !");

		logger.info("chanson to be added " + song);

		try {

			this.songService.createNewSong(song);

			Integer codeArtiste = song.getChansonID().getAlbumID()
					.getIdArtiste();

			Integer codeAlbum = song.getChansonID().getAlbumID().getIdAlbum();

			model.addAttribute("codeArtiste", codeArtiste);

			model.addAttribute("codeAlbum", codeAlbum);

			model.addAttribute("songs", this.songService
					.findSongsByCodeArtisteCodeAlbum(codeArtiste, codeAlbum));

		} catch (Exception e) {

			e.printStackTrace();

		}

		logger.info("form control treated !");

		return "songs";

	}

	/**
	 * Suppression d'une chanson
	 * 
	 * @param  	Integer codeArtiste 
	 * @param	Integer codeAlbum 
	 * @param	Integer codeChanson
	 */
	@RequestMapping(value = "/DeleteSong", method = RequestMethod.GET)
	public ModelAndView deleteSong(
			@RequestParam("codeArtiste") Integer codeArtiste,
			@RequestParam("codeAlbum") Integer codeAlbum,
			@RequestParam("codeChanson") Integer codeChanson, Model model)
			throws Exception {

		logger.info("In displaySongs (Controller)");

		this.songService.deleteSong(this.songService
				.findSongByCodeChansonCodeArtisteCodeAlbum(codeArtiste,
						codeAlbum, codeChanson));

		String url = "redirect:Songs.do?codeArtiste=" + codeArtiste
				+ "&codeAlbum=" + codeAlbum;

		return new ModelAndView(url);
	}

	/**
	 * Initialise le formulaire d'edition d'une chanson
	 * 
	 * @param 	Integer codeArtiste 
	 * @param	Integer codeAlbum 
	 * @param	Integer codeChanson
	 */
	@RequestMapping(value = "/updateSong", method = RequestMethod.GET)
	public String updateSong(@RequestParam("codeArtiste") Integer codeArtiste,
			@RequestParam("codeAlbum") Integer codeAlbum,
			@RequestParam("codeChanson") Integer codeChanson, Model model)
			throws Exception {

		model.addAttribute("Chanson", this.songService
				.findSongByCodeChansonCodeArtisteCodeAlbum(codeArtiste,
						codeAlbum, codeChanson));

		return "song-edit";

	}

	/**
	 * Traite l'objet modifié et le traite en bdd
	 * 
	 * @param : Chanson chanson
	 */
	@RequestMapping(value = "/SongToUpdate", method = RequestMethod.POST)
	public String updateSong(@Valid @ModelAttribute("Chanson") Chanson song,
			BindingResult result, ModelMap model) throws Exception {

		this.songService.updateSong(song);

		model.addAttribute(
				"songs",
				songService.findSongsByCodeArtisteCodeAlbum(song.getChansonID()
						.getAlbumID().getIdArtiste(), song.getChansonID()
						.getAlbumID().getIdAlbum()));

		return "songs";

	}

}
