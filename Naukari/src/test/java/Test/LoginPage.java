package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton = By.xpath("//div[text()='Login']");
    By emailField = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
    By passwordField = By.xpath("//input[@placeholder='Enter your password']");
    By submitButton = By.xpath("//button[text()='Login']");

    public void login(String email, String password) {
        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}