package pageobjects.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class WikipediaPageObject extends BasePage{

	public WikipediaPageObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//th[text()='Directed by']/following-sibling::td/a")
	private WebElement lnk_director;
	
	@FindBy(xpath="//div/cite[contains(text(),'en.wikipedia.org')]")
	private WebElement lnk_wikipedia;
	
	@FindBy(xpath = "(//*[contains(@href,'imdb')])[last()]")
    private WebElement imdbLinkFromWiki; 

	public String getDirector() throws Exception {
		return pageWebDriverClient.getAttribute(lnk_director, "title");
	}
	
	public boolean goToWikipediaLink() throws Exception {
		return pageWebDriverClient.click(lnk_wikipedia);
	}
	
	public void setUrl(String Url) {
		pageWebDriverClient.setURL(Url);
		}

    public String getImdLink() throws Exception {
    	return pageWebDriverClient.getAttribute(imdbLinkFromWiki, "href");
        }
}
