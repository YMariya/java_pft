package ru.stqa.pft.mantis.manager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import ru.stqa.pft.mantis.manager.AppManager;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {
    private CloseableHttpClient httpclient;
    private AppManager app;
    public HttpSession(AppManager app) {
        this.app = app;
        httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public boolean login(String username, String password) throws IOException {
        HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/login.php");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("secure_session", "on"));
        params.add(new BasicNameValuePair("return", "index.php"));
        post.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpclient.execute(post);
        String body = geTextFrom(response);
        return body.contains(String.format("<span class=\"user-info\">%s</span>", username));
    }

    private String geTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        }finally {
            response.close();
        }
    }


    public boolean isLoggedInAs(String username) throws IOException {
        HttpGet get = new HttpGet(app.getProperty("web.baseUrl") + "/index.php");
        CloseableHttpResponse response = httpclient.execute(get);
        String body = geTextFrom(response);
//    return body.contains(String.format("<span class=\"italic\">%s</span>", username));
        return body.contains(String.format("<span class=\"user-info\">%s</span>", username));
    }

}

