package core;

import java.util.HashMap;

import org.testng.annotations.Factory;

import model.MovieDetails;
import testcases.DirectorMatch;
import testcases.DirectorMatchAPI;
import utilities.fileUtils;
import workflow.Workflow;

public class TestFactory {
	public static HashMap<String, MovieDetails> movieMap ;
	
	@Factory
	public Object[] createInstances() throws Exception {
		String platform = System.getProperty("platform");
		fileUtils fileutils = new fileUtils();
		movieMap = fileutils.readMovieName();
		Workflow wf = new Workflow();
		wf.extractWikiUrlAndSetPlatform();
		Object[] result = new Object[movieMap.size()];
		
		int j = 0;
		if(platform.equalsIgnoreCase("api")) {
		for (String i : movieMap.keySet()) {
			result[j] = new DirectorMatchAPI(movieMap.get(i));
			j++;
		}
		}else {
			for (String i : movieMap.keySet()) {
				result[j] = new DirectorMatch(movieMap.get(i));
				j++;
			}
		}
		return result;
	}

	/* public Class< ? > findClassByName(String className,String platform) throws Exception {
	        String searchPackages = "pageobjects";
	               return Class.forName(searchPackages + "." + platform + "." + className);
	            
	        }*/
}