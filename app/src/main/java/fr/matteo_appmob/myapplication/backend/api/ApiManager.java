package fr.matteo_appmob.myapplication.backend.api;

import android.widget.Toast;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

import javax.net.ssl.SSLSession;

import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClients;
import cz.msebera.android.httpclient.util.EntityUtils;
import fr.matteo_appmob.myapplication.RankingActivity;

public class ApiManager {

    private static final String URL = "http://localhost:3000";

    public static String get(String endpoint) throws IOException {
        CloseableHttpClient httpClient   = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL + endpoint);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        return EntityUtils.toString(response.getEntity());
    }

    public static String post(String endpoint, StringEntity body) throws IOException {
        CloseableHttpClient httpClient   = HttpClients.createDefault();
        HttpPost httpPost      = new HttpPost(URL + endpoint);
        httpPost.setEntity(body);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response     = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity());
    }
}
