package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import model.MovieDetails;

public class fileUtils {

	private String MOVIE_TEST_DATA = "/testData/movies.txt";
	HashMap<String, MovieDetails> movieMap = new HashMap<String, MovieDetails>();
	
	public HashMap<String, MovieDetails> readMovieName() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/test/resources/" + MOVIE_TEST_DATA));
			String line ="";
			while ((line = br.readLine()) != null) {
				String[] movieInfo = line.split("\\t");
				if(movieInfo.length>0) {
					MovieDetails movieDetail = new MovieDetails(movieInfo[0]);
					movieDetail.setMovie_name(movieInfo[1]);
					movieMap.put(movieInfo[1], movieDetail);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			br.close();
		}
		return movieMap;
	} 
}
