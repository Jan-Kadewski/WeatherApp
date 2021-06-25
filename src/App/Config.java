package App;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Config {
    final String key;
    String city;
    int currentTemp;
    String country;


    String testResponse;
    int status;

    public Config() {
        key = "54a17707f7fdd825511a71a9d7d09620";
        initData();
    }

    public void initData(){
        city = "";
        testResponse = "";
        currentTemp = 0;
        country = "";

    }

    public void getDataFromWeatherApi() throws IOException, InterruptedException {

        final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_URL))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        status = response.statusCode();
        
        testResponse = response.body();


    }
}
