package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    By resumeUploadInput = By.xpath("//input[@type='file' and contains(@name, 'resumeUpload')]");

    public void uploadResume(String filePath) throws InterruptedException {
        driver.get("https://www.naukri.com/mnjuser/profile");
        Thread.sleep(5000); // Use WebDriverWait in real tests
        driver.findElement(resumeUploadInput).sendKeys(filePath);
        System.out.println("📄 Resume uploaded successfully!");
    }
}
