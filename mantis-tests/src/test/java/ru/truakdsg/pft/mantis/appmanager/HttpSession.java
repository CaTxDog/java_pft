package ru.truakdsg.pft.mantis.appmanager;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {
  private CloseableHttpClient httpClient;
  private ApplicationManager app;

  public HttpSession (ApplicationManager app){
    this.app = app;
    httpClient = HttpClients.custom().setRedirectStrategy(new DefaultRedirectStrategy()).build();

  }

  public boolean login (String username, String password) throws IOException, ParseException {
    HttpPost post = new HttpPost(app.getProperty("web.baseUrl")+"/login.php");
    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    params.add(new BasicNameValuePair("secure_session", "on"));
    params.add(new BasicNameValuePair("return", "index.php"));
    post.setEntity(new UrlEncodedFormEntity(params));
    CloseableHttpResponse respone = httpClient.execute(post);
    String body = geTextFrom(respone);
    return body.contains(String.format("<span class=\"user-info\">%s</span>", username));
  }

  private String geTextFrom(CloseableHttpResponse respone) throws IOException, ParseException {
    try {
      return EntityUtils.toString(respone.getEntity());
    } finally {
      respone.close();
    }
  }
  public boolean isLoggedInAs (String username) throws IOException, ParseException {
    HttpGet get = new HttpGet(app.getProperty("web.baseUrl")+"/login.php");
    CloseableHttpResponse response = httpClient.execute(get);
    String body = geTextFrom(response);
    return body.contains(String.format("<span class=\"user-info\">%s</span>", username));
  }
}
