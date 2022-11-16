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

import SWD4TN020.Music.domain.RecordLabel;
import SWD4TN020.Music.domain.RecordLabelRepository;

@Controller
public class RecordLabelController {
	
	@Autowired
	private RecordLabelRepository rrepository;
	
	// RESTful service to get all record labels
    @RequestMapping(value="/recordlabels", method = RequestMethod.GET)
    public @ResponseBody List<RecordLabel> recordLabelListRest() {	
        return (List<RecordLabel>) rrepository.findAll();
    }

	// RESTful service to get record label by id
    @RequestMapping(value="/recordlabels/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<RecordLabel> findRecordLabelRest(@PathVariable("id") Long recordLabelId) {	
    	return rrepository.findById(recordLabelId);
    }      
    
    // RESTful service to save new record label
    @RequestMapping(value="/recordlabels", method = RequestMethod.POST)
    public @ResponseBody RecordLabel saveRecordLabelRest(@RequestBody RecordLabel recordLabel) {	
    	return rrepository.save(recordLabel);
    }
    
    // RESTful service to delete record label
    @DeleteMapping("/recordlabels/{id}")
    public @ResponseBody void deleteRecordLabelRest(@PathVariable("id") Long recordLabelId) {
    	rrepository.deleteById(recordLabelId);
    }
	
	// record labels listed
	@GetMapping(value="/recordlabel_list")
    public String recordLabelList(Model model) {	
        model.addAttribute("recordlabels", rrepository.findAll());
        return "recordlabellist";
    }
    
	// add record label
	@RequestMapping(value = "/add_recordlabel")
    public String addRecordLabel(Model model){
    	model.addAttribute("recordlabel", new RecordLabel());
    	model.addAttribute("recordlabels", rrepository.findAll());
        return "addrecordlabel";
    }
	
	// save record label
	@PostMapping(value = "/save_recordlabel")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String saveRecordLabel(@Valid RecordLabel recordLabel, BindingResult result, Model model){
		if (result.hasErrors()) {
			model.addAttribute("recordlabels", rrepository.findAll());
    		return "addrecordlabel";
    	}
        rrepository.save(recordLabel);
        return "redirect:/recordlabel_list";
    }

}
