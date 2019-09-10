package browserfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverManagerFactory {

	private static ThreadLocal<AppiumDriver<MobileElement>> threadAppiumDriver = new ThreadLocal<AppiumDriver<MobileElement>>();
	private static ThreadLocal<RemoteWebDriver> threadDesktopWebDriver = new ThreadLocal<RemoteWebDriver>();
	String hub = System.getProperty("hub");

	public AppiumDriver<MobileElement> getAppiumDriver() {
		AppiumDriver<MobileElement> wdriver = threadAppiumDriver.get();
		return wdriver;
	}
	
	public WebDriver getDesktopWebDriver() {
		WebDriver wdriver = threadDesktopWebDriver.get();
		return wdriver;
	}
	
	public static void setAppiumDriver(AppiumDriver<MobileElement> driver) {
		threadAppiumDriver.set(driver);
	}
	
	public static void setDesktopWebDriver(RemoteWebDriver driver) {
		threadDesktopWebDriver.set(driver);
	}
	
	public void initializeDriver(String platform) throws MalformedURLException {
		if(platform.equals("desktop")) {
			initializeChromeWebDriver();
		} else if(platform.equals("mobile")) {
			initializeMobileDriver();
		}
	}
	
	public Object getDriver(String platform) throws MalformedURLException {
		if(platform.equals("desktop")) {
			return getDesktopWebDriver();
		} else if(platform.equals("mobile")) {
			return getAppiumDriver();
		}
		return null;
	}
	
	public void initializeChromeWebDriver() throws MalformedURLException {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 ChromeOptions options = new ChromeOptions();
	     capabilities.setCapability("platformName", "WINDOWS");
		options.addArguments("start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--dns-prefetch-disable");
		options.merge(capabilities);
		setDesktopWebDriver(new RemoteWebDriver(new URL(hub), options));
	}
	
	public void initializeMobileDriver() throws MalformedURLException {
		ChromeOptions options=new ChromeOptions();
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        //capabilities.setCapability("browserName", "Chrome");
	        capabilities.setCapability("deviceName", "9243934");
	        //capabilities.setCapability("deviceId", "192.168.0.27:5000");
	        capabilities.setCapability("platformVersion", "9");
	        capabilities.setCapability("platformName", "ANDROID");

	        capabilities.setCapability("appPackage", "com.google.android.youtube");
	        capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
	        options.merge(capabilities);
			setAppiumDriver(new AppiumDriver<MobileElement>(new URL(hub), options));	
	}
	
	public void closeAllDriver() {
		 if(getAppiumDriver()!=null) {
			getAppiumDriver().quit();
		}
		if (getDesktopWebDriver()!=null)  {
			getDesktopWebDriver().quit();
		}
		
	}
	}
