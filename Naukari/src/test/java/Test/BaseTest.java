package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public void setup() {
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-save-password");
		options.addArguments("--disable-features=site-per-process");

		// Add the preference to disable the save password prompt
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--ignore-certificate-errors");

		options.addArguments("--disable-popup-blocking"); // Disable all pop-ups
		options.addArguments("--disable-notifications"); // Disable all notifications
		options.addArguments("--disable-infobars"); // Disable infobars
		options.addArguments("--disable-extensions"); // Disable all extensions
		options.addArguments("--disable-save-password"); // Disable save password prompt


		// Use the options when creating the ChromeDriver
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.naukri.com/");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}