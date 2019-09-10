package pageobjects.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class GoogleWebPageObject extends BasePage{

	public GoogleWebPageObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name= "q")
	private WebElement search_text;
	
	@FindBy(xpath="//input[contains(text(),'wikipedia')]")
	private WebElement search_input;
	
	private String wikiLink = "//a[starts-with(@href,'https://en.wikipedia.org/wiki')]";

	public boolean searchMovie(String moviename) throws Exception {
		return pageWebDriverClient.setTextAndEnter(search_text, moviename);
	}
	
	public String getWikiLink() throws Exception {
		if(pageWebDriverClient.isWebElementDisplayed(wikiLink))
		return pageWebDriverClient.getAttribute(wikiLink,"href");
		else return "No url found";
	}
	
	public void setUrl(String Url) {
		pageWebDriverClient.setURL(Url);
		}


}
