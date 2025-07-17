package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;

public class Naukariflow {

	public static void main(String[] args) {

		// Set path to chromedriver (adjust if needed)
		// WebDriverManager.chromedriver().setup();

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

		try {
			// 1. Navigate to Naukri
			driver.get("https://www.naukri.com/");

			// 2. Click Login
			driver.findElement(By.xpath("//a[normalize-space(text())='Login']")).click();

			// 3. Enter credentials
			driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
					.sendKeys("arul.arul.patil6@gmail.com");

			driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("9870677609");

			driver.findElement(By.xpath("//button[text()='Login']")).click();

			// Wait briefly to ensure dashboard loads
			Thread.sleep(5000);

			// 4. Click on "View & Update Profile"
			driver.get("https://www.naukri.com/mnjuser/profile");

			// Wait to load profile page
			Thread.sleep(5000);

			// 5. Update resume headlines
			WebElement resumehed = driver.findElement(By.xpath("(//div[@class='widgetHead']//span)[2]"));
			resumehed.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//textarea[@class='resumeHeadlineTxt materialize-textarea']")));
			// click on the compose button as soon as the "resume" button is visible

			WebElement resumehedupdate = driver
					.findElement(By.xpath("//textarea[@class='resumeHeadlineTxt materialize-textarea']"));
			resumehedupdate.click();
			resumehedupdate.clear();
			resumehedupdate.sendKeys(
					"8+ year Experience in Automation Testing, java, selenium Web driver, TestNG, Cucumber, Rest assured, maven _ Immediately joiner.");
			WebElement savebtn = driver.findElement(By.xpath("//button[normalize-space(text())='Save']"));
			savebtn.click();
			WebElement sucess = driver.findElement(By.xpath("//i[@class='icon']/following-sibling::p[1]"));
			String message = sucess.getText();

			if (message.equalsIgnoreCase("Success")) {
				System.out.println("Data updated successfully!");
			} else {
				System.out.println("Data is not updated!");
			}
//-------------------------------------
			resumehed.click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//textarea[@class='resumeHeadlineTxt materialize-textarea']")));
			// click on the compose button as soon as the "resume" button is visible

			WebElement resumehedupdate0 = driver.findElement(By.xpath("//div[@class='input-field s12']//textarea[1]"));
			resumehedupdate0.click();
			resumehedupdate0.clear();
			resumehedupdate0.sendKeys(
					"8+ year Experience in Automation Testing, java, selenium Web driver, TestNG, Cucumber, Rest assured, maven _ Immediately joiner");
			WebElement savebtn1 = driver.findElement(By.xpath("//button[normalize-space(text())='Save']"));
			savebtn1.click();
			WebElement sucess0 = driver.findElement(By.xpath("//i[@class='icon']/following-sibling::p[1]"));
			String message0 = sucess0.getText();

			if (message0.equalsIgnoreCase("Success")) {
				System.out.println("Data updated successfully!");
			} else {
				System.out.println("Data is not updated!");
			}
//	            // 5. Upload Resume
//	            WebElement uploadBtn = driver.findElement(By.xpath("//input[@type='file' and contains(@name, 'resumeUpload')]"));
//	            uploadBtn.sendKeys("C:\\path\\to\\your\\resume.pdf"); // Replace with your actual file path
//
//	            System.out.println("📄 Resume uploaded successfully!");

			// 6. Logout (hover & click)
			WebElement userIcon = driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']"));
			userIcon.click();

			WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Logout']"));
			logoutBtn.click();

			System.out.println("🔓 Logged out successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
