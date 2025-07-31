package Test;

public class TestRunner extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        TestRunner test = new TestRunner();
        test.setup();
        
        String excelPath = System.getProperty("user.dir") + "/External/Arulpatil_8 years experience_N.docx";

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.login("arul.arul.patil6@gmail.com", "9870677609");

        // Resume Upload
        ProfilePage profilePage = new ProfilePage(test.driver);
      //  profilePage.uploadResume("C:\\Users\\user\\git\\Naukari\\Naukari\\src\\test\\resources\\External\\Arulpatil_8 years_N.docx");
        profilePage.uploadResume(excelPath);

        // Logout
        LogoutPage logoutPage = new LogoutPage(test.driver);
        logoutPage.logout();

        test.tearDown();
    }
}
