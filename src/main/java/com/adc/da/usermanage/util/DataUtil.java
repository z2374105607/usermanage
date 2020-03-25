package com.adc.da.usermanage.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.adc.da.usermanage.constant.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by admin on 2018/10/18.
 */
public class DataUtil {

    public static List<LinkedHashMap<String, Object>> getData(String url){

        org.springframework.http.HttpEntity<String> rq = null;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = null;
        List<LinkedHashMap<String, Object>> map = null;
        rq = new org.springframework.http.HttpEntity<String>(getHeadersWithClientCredentials(Constant.GROUP_AUTH_CLIENT_CLIENTID,
                Constant.GROUP_AUTH_CLIENT_CLIENTSECRET));
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
       
        response = restTemplate.exchange(url, HttpMethod.GET, rq, Object.class);
        Object resultBody = response.getBody();
        if (resultBody instanceof List) {
            map = (List<LinkedHashMap<String, Object>>) resultBody;
        } else if (resultBody instanceof LinkedHashMap){
            map = new ArrayList<LinkedHashMap<String, Object>>();
            map.add((LinkedHashMap<String, Object>)resultBody);
        } else {
            map = new ArrayList<LinkedHashMap<String, Object>>();
        }
        return map;
    }

    private static HttpHeaders getHeadersWithClientCredentials(String clientId, String clientSecret){
        String plainClientCredentials=clientId + ":" +clientSecret;
        String base64ClientCredentials = (Base64.getEncoder().encodeToString(plainClientCredentials.getBytes()));

        HttpHeaders headers = getHeaders();
        headers.add("apikey", "413d0d7a09314d59a3211927b2d6dee9");
        return headers;
    }

    private static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return headers;
    }
}
