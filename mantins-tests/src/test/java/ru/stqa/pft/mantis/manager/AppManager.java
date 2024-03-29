package ru.stqa.pft.mantis.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import  ru.stqa.pft.mantis.appmanager.FtpHelper;
import ru.stqa.pft.mantis.manager.ChangePassHelper;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import  ru.stqa.pft.mantis.appmanager.MailHelper;
public class AppManager {
    private final Properties properties;
    public WebDriver wd;

    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;
    private ChangePassHelper changeHelper;

    public AppManager(String browser) {

        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }


    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if(registrationHelper == null){
            registrationHelper = new RegistrationHelper(this);
        }
     return  registrationHelper;
    }


        public  FtpHelper ftp() {
        if (ftp == null) {
            ftp = new FtpHelper(this);
        }
        return  ftp;
    }

    public WebDriver getDriver() {
        if (wd == null) {

            if (browser == Browser.FIREFOX.browserName()) {
                wd = new FirefoxDriver();
            } else if (browser == Browser.CHROME.browserName()) {
                wd = new ChromeDriver();
            } else if (browser == Browser.IE.browserName()) {
                wd = new InternetExplorerDriver();
            }
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            wd.get(properties.getProperty("web.baseUrl"));

        }


        return wd;
    }
    public MailHelper mail() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }
    public ChangePassHelper change() {
        if (changeHelper == null) {
            changeHelper = new ChangePassHelper(this);
        }
        return changeHelper;
    }


}


