package ru.stqa.pft.mantis.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AppManager {
    private final Properties properties;
    public WebDriver wd;
     private String browser;


    public AppManager(String browser)  {

        this.browser = browser;
        properties = new Properties();
   }

    public void init() throws IOException {
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));



        if (browser == Browser.FIREFOX.browserName()){
            wd = new FirefoxDriver();
        }
        else if (browser == Browser.CHROME.browserName()){
            wd = new ChromeDriver();
        }
        else if (browser == Browser.IE.browserName()){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wd.get(properties.getProperty("web.baseUrl"));

    }


    public void stop() {
        wd.quit();
    }

   }
