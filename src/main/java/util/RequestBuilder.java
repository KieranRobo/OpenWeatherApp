package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class RequestBuilder {

    private final String apiUrl;
    private final String apiKey;

    public RequestBuilder(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public String makeRequest(String endpoint, Map<String, String> params) {
        try {
            URL urlObj = new URL(constructUrlFromMap(endpoint, params));
            return convertInputStreamToString(excecuteRequest(urlObj));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String constructUrlFromMap(String endpoint, Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        query.append("/");
        query.append(endpoint);

        query.append("?");
        query.append("appid");
        query.append("=");
        query.append(apiKey);

        for (String key : params.keySet()) {
            query.append("&");
            query.append(key);
            query.append("=");
            query.append(params.get(key));
        }
        query.insert(0, apiUrl);
        return query.toString();
    }

    private InputStream excecuteRequest(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    private static String convertInputStreamToString(InputStream inputStream) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
