package testcases;

import org.testng.annotations.Test;

import core.BaseTest;
import model.MovieDetails;

public class DirectorMatchAPI extends BaseTest{
	
	MovieDetails movieDetails;
	public DirectorMatchAPI(MovieDetails movieDetails) {
		// TODO Auto-generated constructor stub
		this.movieDetails  = movieDetails;
	}

	@Test
	public void AssertTestDirector() throws Exception {
		System.out.println("Under API");
	}
	
	
}
