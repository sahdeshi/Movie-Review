package ca.sheridancollege.sahdeshi.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sahdeshi.beans.Movie;


@Repository
public class DatabaseAccess {

	@Autowired
	
	protected NamedParameterJdbcTemplate jdbc;
	public void insertReview(Movie movie) {
		
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO MovieTime(id, movie, review, point, reviewDate, reviewTime, streamingService) "
				+ "VALUES (:id, :movie, :review, :points , :reviewDate, :reviewTime, :str)";
		namedParameters.addValue("review", movie.getReview());
		namedParameters.addValue("reviewTime", movie.getReviewTime());
		namedParameters.addValue("reviewDate", movie.getReviewDate());
		namedParameters.addValue("points", movie.getPoint());
		namedParameters.addValue("movie", movie.getMovie());
		namedParameters.addValue("id", movie.getId());
		namedParameters.addValue("str", movie.getStreamingService());
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("Inserted Review into database.");
		
	}
	public List<Movie> getMovieReview() {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		String query = "SELECT * FROM MovieTime";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Movie>(Movie.class));
		
	}
		
	}
	

