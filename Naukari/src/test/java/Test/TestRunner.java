package Test;

public class TestRunner extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        TestRunner test = new TestRunner();
        test.setup();

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.login("your_email@example.com", "your_password");

        // Resume Upload
        ProfilePage profilePage = new ProfilePage(test.driver);
        profilePage.uploadResume("C:\\path\\to\\your\\resume.pdf");

        // Logout
        LogoutPage logoutPage = new LogoutPage(test.driver);
        logoutPage.logout();

        test.tearDown();
    }
}
