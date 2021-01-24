package ca.sheridancollege.sahdeshi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.sahdeshi.beans.Movie;
import ca.sheridancollege.sahdeshi.database.DatabaseAccess;

@Controller
public class MovieController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList", da.getMovieReview());
		
		
		return "index";
		
	}
	
	@PostMapping("/insertReview")
	public String insertReview(Model model, @ModelAttribute Movie movie ) {
		da.insertReview(movie);
		
		model.addAttribute("movieList", da.getMovieReview());
		model.addAttribute("movie", new Movie());
		return "index";
	}
}
