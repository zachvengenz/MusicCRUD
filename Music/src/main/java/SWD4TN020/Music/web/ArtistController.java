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

import SWD4TN020.Music.domain.Artist;
import SWD4TN020.Music.domain.ArtistRepository;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistRepository artrepository;
	
	// RESTful service to get all artists
    @RequestMapping(value="/artists", method = RequestMethod.GET)
    public @ResponseBody List<Artist> artistListRest() {	
        return (List<Artist>) artrepository.findAll();
    }

	// RESTful service to get artist by id
    @RequestMapping(value="/artists/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Artist> findArtistRest(@PathVariable("id") Long artistId) {	
    	return artrepository.findById(artistId);
    }      
    
    // RESTful service to save new artist
    @RequestMapping(value="/artists", method = RequestMethod.POST)
    public @ResponseBody Artist saveArtistRest(@RequestBody Artist artist) {	
    	return artrepository.save(artist);
    }
    
    // RESTful service to delete artist
    @DeleteMapping("/artists/{id}")
    public @ResponseBody void deleteArtistRest(@PathVariable("id") Long artistId) {
    	artrepository.deleteById(artistId);
    }
	
	
	// artists listed
	@GetMapping(value="/artist_list")
    public String artistList(Model model) {	
        model.addAttribute("artists", artrepository.findAll());
        return "artistlist";
    }
	
	// add artist
	@RequestMapping(value = "/add_artist")
    public String addArtist(Model model){
    	model.addAttribute("artist", new Artist());
    	model.addAttribute("artists", artrepository.findAll());
        return "addartist";
    }
	
	// save artist
	@PostMapping(value = "/save_artist")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String saveArtist(@Valid Artist artist, BindingResult result, Model model){
    	if (result.hasErrors()) {
    		model.addAttribute("artists", artrepository.findAll());
    		return "addartist";
    	}
        artrepository.save(artist);
        return "redirect:/artist_list";
    }
	
	// delete artist
    @GetMapping("/delete_artist/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteArtist(@PathVariable("id") Long artistId, Model model) {
    	artrepository.deleteById(artistId);
        return "redirect:/artist_list";
    } 
    
	// edit artist
	@GetMapping("/edit_artist/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editArtist(@PathVariable("id") Long artistId, Model model) {
    	Artist artist = artrepository.findById(artistId)
    	.orElseThrow(() -> new IllegalArgumentException("Invalid id" + artistId));

    	model.addAttribute("artist", artist);
		
		return "editartist";	
	}
	
	// update artist
	@PostMapping("/update_artist/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
    public String updateArtist(@PathVariable("id") Long artistId, Model model, Artist artist, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("artists", artrepository.findAll());
            return "editartist";
        }
        artist.setArtistId(artistId);
        artrepository.save(artist);
        return "redirect:/artist_list";
    } 

}
