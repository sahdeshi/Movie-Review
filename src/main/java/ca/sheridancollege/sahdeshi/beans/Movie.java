package ca.sheridancollege.sahdeshi.beans;


//import java.util.Time;
//import java.util.Date;

//import java.sql.Date;
import java.time.LocalDate;
//import java.sql.Time;
//import java.sql.Time;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


public class Movie {

	
	
	private String movie;
	
	private String [] movies = {"Enola Holmes", "Thor: The Dark World", "Kabir Singh" , "The NUN"};
	private Long id;
	private String review;
	private int point;
	
	private int [] points= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalTime reviewTime = LocalTime.now();
	@DateTimeFormat(pattern = "hh:mm")
	private LocalDate reviewDate = LocalDate.now();
	private String streamingService;
}
