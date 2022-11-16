package SWD4TN020.Music.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import SWD4TN020.Music.domain.Album;
import SWD4TN020.Music.domain.AlbumRepository;
import SWD4TN020.Music.domain.ArtistRepository;
import SWD4TN020.Music.domain.RecordLabelRepository;
import SWD4TN020.Music.domain.TrackRepository;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumRepository arepository;
	
	@Autowired
	private ArtistRepository artrepository;
	
	@Autowired
	private TrackRepository trepository;
	
	@Autowired
	private RecordLabelRepository rrepository;
	
	// RESTful service to get all albums
    @RequestMapping(value="/albums", method = RequestMethod.GET)
    public @ResponseBody List<Album> albumListRest() {	
        return (List<Album>) arepository.findAll();
    }

	// RESTful service to get album by id
    @RequestMapping(value="/albums/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long albumId) {	
    	return arepository.findById(albumId);
    }      
    
    // RESTful service to save new album
    @RequestMapping(value="/albums", method = RequestMethod.POST)
    public @ResponseBody Album saveAlbumRest(@RequestBody Album album) {	
    	return arepository.save(album);
    }
    
    // RESTful service to delete album
    @DeleteMapping("/albums/{id}")
    public @ResponseBody void deleteAlbumRest(@PathVariable("id") Long albumId) {
    	arepository.deleteById(albumId);
    }
	
	// to first page
	@GetMapping(value="/")
    public String firstPage() {	
        return "firstpage";
    }
	
	// albums listed
	@GetMapping(value="/album_list")
    public String albumList(Model model) {	
        model.addAttribute("albums", arepository.findAll());
        return "albumlist";
    }
	
	// add album
	@RequestMapping(value = "/add_album")
    public String addAlbum(Model model){
    	model.addAttribute("album", new Album());
    	model.addAttribute("albums", arepository.findAll());
		model.addAttribute("artists", artrepository.findAll());
		model.addAttribute("recordlabels", rrepository.findAll());
        return "addalbum";
    }
	
	// save album
	@PostMapping(value = "/save_album")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String saveAlbum(@Valid Album album, BindingResult result, Model model){
    	if (result.hasErrors()) {
    		model.addAttribute("albums", arepository.findAll());
    		model.addAttribute("artists", artrepository.findAll());
    		model.addAttribute("recordlabels", rrepository.findAll());
    		return "addalbum";
    	}
        arepository.save(album);
        return "redirect:/add_track";
    }
	
	// edit album
	@GetMapping("/edit_album/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editAlbum(@PathVariable("id") Long albumId, Model model) {
    	Album album = arepository.findById(albumId)
    	.orElseThrow(() -> new IllegalArgumentException("Invalid id" + albumId));

    	model.addAttribute("album", album);
		model.addAttribute("artists", artrepository.findAll());
		model.addAttribute("tracks", trepository.findAll());
		model.addAttribute("recordlabels", rrepository.findAll());
		
		return "editalbum";
	}
	
	// update album
	@PostMapping("/update_album/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
    public String updateAlbum(@PathVariable("id") Long albumId, Model model, Album album, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("albums", arepository.findAll());
            return "editalbum";
        }
        album.setAlbumId(albumId);
        arepository.save(album);
        return "redirect:/album_list";
    }
    
	// delete album
    @GetMapping("/delete_album/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteAlbum(@PathVariable("id") Long albumId, Model model) {
    	arepository.deleteById(albumId);
        return "redirect:/album_list";
    }
    
    // show albums from certain artist
 	@GetMapping(value="/artist_albums/{id}")
     public String artistAlbums(@PathVariable("id") Long artistId, Model model) {
     	model.addAttribute("artist", artrepository.findByArtistId(artistId));
        model.addAttribute("albums", arepository.findAll());

         return "artistalbums";
     }

}
