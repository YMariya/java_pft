package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.manager.AppManager;

public class TestBase {

    protected static final AppManager app
            = new AppManager(System.getProperty("browser",
            Browser.FIREFOX.browserName()));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {

        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }
}
