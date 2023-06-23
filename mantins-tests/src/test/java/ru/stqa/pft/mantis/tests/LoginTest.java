package ru.stqa.pft.mantis.tests;
import org.testng.annotations.Test;
import java.io.IOException;
import ru.stqa.pft.mantis.manager.HttpSession;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends TestBase {
    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}