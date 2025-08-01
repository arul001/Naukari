package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

public class cvUpdated {

	public static void main(String[] args) {

		// Set path to chromedriver (adjust if needed)
		// WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		// Disable Chrome Password Manager
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false); // Disable password manager
		prefs.put("profile.password_manager_enabled", false); // Disable save password prompt

		options.setExperimentalOption("prefs", prefs);

		// Disable automation flags and extensions
		options.addArguments("--disable-save-password-bubble"); // This may help prevent password popups
		options.addArguments("--disable-notifications"); // Optional: disable all Chrome notifications

		WebDriver driver = new ChromeDriver(options);

		// Use the options when creating the ChromeDriver
		// WebDriver driver = new ChromeDriver(options);

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

			// 5. Upload Resume
			WebElement uploadBtn = driver.findElement(By.xpath("(//input[@type='button'])[1]"));
			Thread.sleep(5000);
			uploadBtn.sendKeys("C:\\Users\\user\\git\\Naukari\\Naukari\\src\\test\\resources\\External\\Arulpatil_8 years experience_N.docx"); // Replace with
																										// your actual
																										// file path 
			System.out.println("📄 Resume uploaded successfully!");

			Date d = new Date();
			String time = d.date();

			// //Uploaded on Jul 08, 2025
			String Expectedmessage = "Uploaded" + " on" + " " + time;

			String uploadedmessage = driver.findElement(By.xpath("//div[@class='updateOn typ-14Regular']")).getText();
			// String uploadedmessage1 = sucess.getText();

			System.out.println("uploadedmessage" + uploadedmessage);
			System.out.println("Expectedmessage" + Expectedmessage);
			if (uploadedmessage.equalsIgnoreCase("Expectedmessage")) {
				System.out.println("Resume updated successfully and its verifies on server text!");
			} else {
				System.out.println("Resume is not updated successfully and its verifies on server text!!");
			}

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
