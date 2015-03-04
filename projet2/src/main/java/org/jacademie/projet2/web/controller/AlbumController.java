package org.jacademie.projet2.web.controller;

import java.util.HashSet;
import java.util.List;
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
public class AlbumController {
	
	private static Logger logger = LogManager.getLogger(AlbumController.class);

	@Autowired
	private 	AlbumService 	albumService;
	
	@Autowired
	private 	ArtisteService 	artisteService;
	
	@Autowired
	private 	SongService 	songService;
	
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
	public String sendSong( @RequestParam("id") Integer id, Model model ) throws Exception {
	     
		model.addAttribute( "id", id );
		
		model.addAttribute( "Album", new Album() );
		
		model.addAttribute( "albums", albumService.findAlbumsByCodeArtiste(id) );
		
		return "albums";
		
	}
	
	@RequestMapping(value = "/AddAlbum", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("Album") Album album, BindingResult result, ModelMap model) {
		
		logger.info( "form control reached !" );
	    
		logger.info( album.toString() );
		
		try {
			
			logger.info( "album persisting..." );
			
			this.albumService.createAlbum(album);
			
			logger.info( "album persisted ! " );
			
			model.addAttribute( "albums", albumService.findAlbumsByCodeArtiste(album.getAlbumID().getIdArtiste()) );
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	      
		logger.info( "form control treated !" );
		
		return "albums";
		
	}
	
	@RequestMapping(value = "/Albums2", method = RequestMethod.GET)
	public String displayArtisteAlbums( Model model ) throws Exception {

		logger.info("In displayArtisteAlbums (Controller)");
		
		List<Album> albums = this.albumService.retrieveAllAlbums();
		
		model.addAttribute("albums", albums);

		logger.info("Out displayArtisteAlbums (Controller)");
		
		return "albums";
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value = "/DeleteAlbum", method = RequestMethod.GET )
    public ModelAndView deleteAlbum(@RequestParam("codeArtiste") Integer codeArtiste, @RequestParam("codeAlbum") Integer codeAlbum, Model model) throws Exception {

		logger.info("In displaySongs (Controller)");
		
		Album album = this.albumService.findAlbumByCodeArtisteCodeAlbum(codeArtiste, codeAlbum);
		  
		album.setChansons(new HashSet<>(this.songService.findSongsByCodeAlbum(codeAlbum)));
		 
		for(Chanson chanson : album.getChansons()){
			
			this.songService.deleteSong(chanson);
		
		}
		
		this.albumService.deleteAlbum(album);
		
		String url = "redirect:Albums.do?id="+codeArtiste;
		
		return new ModelAndView(url);
    }
	
	@RequestMapping(value = "/updateAlbum", method = RequestMethod.GET)
	public String updateAlbum( @RequestParam("codeArtiste") Integer codeArtiste, @RequestParam("codeAlbum") Integer codeAlbum, Model model ) throws Exception {
	     		
		model.addAttribute( "Album", this.albumService.findAlbumByCodeArtisteCodeAlbum(codeArtiste, codeAlbum) );
		
		return "album-edit";
		
	}
	
	@RequestMapping(value = "/AlbumToUpdate", method = RequestMethod.POST)
	public String updateAlbum( @Valid @ModelAttribute("Album") Album album, BindingResult result, ModelMap model ) throws Exception {
	     		
		this.albumService.updateAlbum(album);
		
		model.addAttribute( "albums", albumService.findAlbumsByCodeArtiste(album.getAlbumID().getIdArtiste()) );
		
		return "albums";
		
	}
	
}
