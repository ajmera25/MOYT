package testcases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browserfactory.DriverManagerFactory;
import core.BaseTest;
import core.TestFactory;
import io.appium.java_client.AppiumDriver;
import model.MovieDetails;

public class DirectorMatch extends BaseTest{
	
	MovieDetails movieDetails;
	public DirectorMatch(MovieDetails movieDetails) {
		// TODO Auto-generated constructor stub
		this.movieDetails  = movieDetails;
	}

	@Test
	public void AssertTestDirector() throws Exception {
		Constructor<?> constructor;
		DriverManagerFactory browserFactory = new DriverManagerFactory();
		if(movieDetails.getWiki_url().equals("No url found")) {
			movieDetails.setImdb_directors("");
			movieDetails.setImdb_image("");
			movieDetails.setImdb_url("");
			movieDetails.setWiki_image("");
			movieDetails.setWiki_directors("");
		} else 
		{ try {
			browserFactory.initializeDriver(movieDetails.getPlatform());
			Class<?> clazz = Class.forName("pageobjects" + "." + movieDetails.getPlatform() + "." + "WikipediaPageObject");
			if(movieDetails.getPlatform().equalsIgnoreCase("Desktop")) {
				constructor = clazz.getConstructor(WebDriver.class);
			}else {
				constructor = clazz.getConstructor(AppiumDriver.class);
			}
			Object c = constructor.newInstance(browserFactory.getDriver(movieDetails.getPlatform()));
			
			//String parameter
			Class[] paramString = new Class[1];	
			paramString[0] = String.class;
				
			Method urlMethod = clazz.getDeclaredMethod("setUrl", paramString);
			urlMethod.invoke(c, movieDetails.getWiki_url());
			
			Method getDirector = clazz.getDeclaredMethod("getDirector");
			movieDetails.setWiki_directors(getDirector.invoke(c).toString());
			
			Method getImdbLink = clazz.getDeclaredMethod("getImdLink");
			movieDetails.setWiki_directors(getDirector.invoke(c).toString());
			TestFactory.movieMap.put(movieDetails.getMovie_Id(),movieDetails);
		}/*else {
			browserFactory.initializeDriver(movieDetails.getPlatform());
			WikipediaPageObject wikipage = new WikipediaPageObject(browserFactory.getAppiumDriver());
			wikipage.setUrl(movieDetails.getWiki_url());
			movieDetails.setWiki_directors(wikipage.getDirector());
			movieDetails.setImdb_directors(wikipage.getImdDirector());
			browserFactory.getDesktopWebDriver().quit();
			
		}*/
		catch(Exception e){
			throw e;
		}
		finally {
			browserFactory.closeAllDriver();
		}
		}
	}
	
	
}
