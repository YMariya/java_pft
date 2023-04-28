package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class GroupCreationTests {
    private WebDriver wd;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {

        wd = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) wd;
        login("admin", "secret");
    }


    private void login(String username, String password) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testGroupCreation() throws Exception {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        teturnToGroupPage();
        Logout();
    }

    private void Logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void teturnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    private void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }



    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
