package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver launchBrowser(String browserName) throws MalformedURLException {
		String gridAdd = "http://192.168.56.1:4444/";


		if (browserName.equals("Mozilla")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefox.log");
			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(gridAdd),options); 

			FirefoxProfile prof = new FirefoxProfile();// new Profile
			prof.setPreference("dom.webnotifications.enable", false);
			options.setProfile(prof);

			driver = new FirefoxDriver(options);

		} else if (browserName.equals("Chrome")) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions ops = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(gridAdd),ops); 
			// ops.setBinary("");
			// ops.setPageLoadStrategy(strategy);
			ops.addArguments("---disable-notifications");
			ops.addArguments("start-maximize");
			driver = new ChromeDriver(ops);

		} else if (browserName.equals("Edge")) {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			EdgeOptions ops = new EdgeOptions();
			driver = new RemoteWebDriver(new URL(gridAdd),ops); 

			// ops.setBinary("");
			// ops.setPageLoadStrategy(strategy);
			ops.addArguments("---disable-notifications");
			ops.addArguments("start-maximize");
			driver = new EdgeDriver(ops);
			driver = new EdgeDriver();
		}
		return driver;
	}

}
