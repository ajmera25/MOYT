package utilities;

import java.util.HashMap;

import browserfactory.DriverManagerFactory;
import core.TestFactory;
import model.MovieDetails;
import pageobjects.desktop.GoogleWebPageObject;

public class WikiRunner implements Runnable {
	MovieDetails movieDetails;
	String platform;

	public WikiRunner(MovieDetails movieDetails,String platform) {
		this.movieDetails = movieDetails;
		this.platform = platform;
	}

	@Override
	public void run() {
		DriverManagerFactory browserFactory = new DriverManagerFactory();
		try {
		browserFactory.initializeDriver("desktop");
		GoogleWebPageObject googlepage = new GoogleWebPageObject(browserFactory.getDesktopWebDriver());
		googlepage.setUrl("http://www.google.com"); 
		googlepage.searchMovie(movieDetails.getMovie_name());
		movieDetails.setWiki_url(googlepage.getWikiLink());
		movieDetails.setPlatform(platform);
		TestFactory.movieMap.put(movieDetails.getMovie_name(),movieDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			browserFactory.getDesktopWebDriver().quit();
		}

	}
	
	public HashMap<String, MovieDetails> getResponse(){
		return TestFactory.movieMap;
	}
}
