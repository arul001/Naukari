package Test;

public class TestRunner extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        TestRunner test = new TestRunner();
        test.setup();

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.login("arul.arul.patil6@gmail.com", "9870677609");

        // Resume Upload
        ProfilePage profilePage = new ProfilePage(test.driver);
        profilePage.uploadResume("C:\\path\\to\\your\\resume.pdf");

        // Logout
        LogoutPage logoutPage = new LogoutPage(test.driver);
        logoutPage.logout();

        test.tearDown();
    }
}
