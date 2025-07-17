package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By profileIcon = By.xpath("//div[@class='nI-gNb-drawer__icon']");
    By logoutLink = By.xpath("//a[text()='Logout']");

    public void logout() throws InterruptedException {
        Thread.sleep(3000); // Replace with WebDriverWait
        driver.findElement(profileIcon).click();
        driver.findElement(logoutLink).click();
        System.out.println("🔓 Logged out successfully!");
    }
}