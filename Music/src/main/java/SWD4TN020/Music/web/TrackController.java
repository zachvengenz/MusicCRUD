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

import SWD4TN020.Music.domain.AlbumRepository;
import SWD4TN020.Music.domain.Track;
import SWD4TN020.Music.domain.TrackRepository;

@Controller
public class TrackController {
	
	@Autowired
	private AlbumRepository arepository;
	
	@Autowired
	private TrackRepository trepository;
	
	// RESTful service to get all tracks
    @RequestMapping(value="/tracks", method = RequestMethod.GET)
    public @ResponseBody List<Track> trackListRest() {	
        return (List<Track>) trepository.findAll();
    }

	// RESTful service to get track by id
    @RequestMapping(value="/tracks/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Track> findTrackRest(@PathVariable("id") Long trackId) {	
    	return trepository.findById(trackId);
    }      
    
    // RESTful service to save new track
    @RequestMapping(value="/tracks", method = RequestMethod.POST)
    public @ResponseBody Track saveTrackRest(@RequestBody Track track) {	
    	return trepository.save(track);
    }
    
    // RESTful service to delete track
    @DeleteMapping("/tracks/{id}")
    public @ResponseBody void deleteTrackRest(@PathVariable("id") Long trackId) {
    	trepository.deleteById(trackId);
    }
	
	
	// tracks listed
	@GetMapping(value="/track_list")
    public String trackList(Model model) {
        model.addAttribute("tracks", trepository.findAll());
        return "tracklist";
    }
	
	// add track
	@RequestMapping(value = "/add_track")
    public String addTrack(Long albumId, Model model){
    	model.addAttribute("track", new Track());
    	model.addAttribute("album", arepository.findTopByOrderByAlbumIdDesc());
    	model.addAttribute("albums", arepository.findAll());
    	model.addAttribute("tracks", trepository.findAll());
        return "addtrack";
    }
	
	// save track
	@PostMapping(value = "/save_track")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String saveTrack(@Valid Track track, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("album", arepository.findTopByOrderByAlbumIdDesc());
			return "addtrack";
		}
        trepository.save(track);
        return "redirect:/add_track";
    }
	
	// show tracks from certain album
	@GetMapping(value="/album_tracks/{id}")
    public String albumTracks(@PathVariable("id") Long albumId, Model model) {
    	model.addAttribute("album", arepository.findByAlbumId(albumId));
       	model.addAttribute("tracks", trepository.findAll());

        return "albumtracklist";
    }
	

}
