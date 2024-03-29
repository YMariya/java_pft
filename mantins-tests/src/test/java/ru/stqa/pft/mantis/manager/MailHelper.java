package ru.stqa.pft.mantis.appmanager;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.stqa.pft.mantis.manager.AppManager;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class MailHelper {
    private AppManager app;
    private final Wiser wiser;

    public MailHelper(AppManager app) {
        this.app = app;
        wiser = new Wiser();
    }

    public List<MailMessage> waitForMail(int count, long timeout) throws MessagingException, IOException {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() < start + timeout) {
            if (wiser.getMessages().size() >= count) {
               return wiser.getMessages().stream().map((m)->toModeMail(m)).collect(Collectors.toList());

            }
            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new Error("No mail");
    }

    public static MailMessage toModeMail(WiserMessage m) {

        try {
            MimeMessage nm = m.getMimeMessage();
             return new MailMessage(nm.getAllRecipients()[0].toString(), (String) nm.getContent());
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void start () {wiser.start();}
    public void stop () {wiser.stop();}

}