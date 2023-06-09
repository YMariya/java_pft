package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.manager.AppManager;

import java.io.File;

public class TestBase {

    protected static final AppManager app
            = new AppManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {

        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"),
                "config_inc.php", "config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.ftp().restore( "config_inc.php.bak", "config_inc.php");
        app.stop();

    }
}
