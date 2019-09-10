package workflow;

import core.TestFactory;
import utilities.ThreadExecutorService;
public class Workflow {

	public void extractWikiUrlAndSetPlatform() throws Exception {
		//String platform = System.getProperty("platform");
		
		ThreadExecutorService threadService = new ThreadExecutorService(TestFactory.movieMap.size());
		// with Runnable
		threadService.getWikiLinks();
	}}

		/*int mobilePlatformCount = Integer.valueOf(System.getProperty("mobileplatform"));
		DriverManagerFactory browserFactory = new DriverManagerFactory();
		for (String movieName : TestFactory.movieMap.keySet()) {
			MovieDetails movieDetails = TestFactory.movieMap.get(movieName);
			browserFactory.initializeDriver("desktop");
				GoogleWebPageObject googlepage = new GoogleWebPageObject(browserFactory.getDesktopWebDriver());
				googlepage.setUrl("http://www.google.com"); 
				googlepage.searchMovie(movieName);
				movieDetails.setWiki_url(googlepage.getWikiLink());
				browserFactory.getDesktopWebDriver().quit();
			else {
				GoogleMobilePageObject googlepage = new GoogleMobilePageObject(browserFactory.getAppiumDriver());
				googlepage.setUrl("http://www.google.com"); 
				googlepage.searchMovie(movieName);
				movieDetails.setWiki_url(googlepage.getWikiLink());
			}
			if (mobilePlatformCount>0) {
			movieDetails.setPlatform("mobile");
			} else 
			movieDetails.setPlatform("desktop");
			mobilePlatformCount--;
			TestFactory.movieMap.put(movieName, movieDetails);
		} */
	


/*Class[] params = new Class[1];
params[0] = "http://www.google.com".getClass();
Object c = tf.findClassByName("GooglePageObject", platform).getDeclaredConstructor(WebDriver.class).newInstance();
Object.class.getMethod("setUrl",params);*/
//googlepage = new GooglePageObject(browserFactory.getDriver(platform));
