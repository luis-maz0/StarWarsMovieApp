import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private String url;
    private HttpClient client;
    private Gson gson;

    public ApiService(String url){
        this.url = url;
        this.gson = new Gson();
        this.client = HttpClient.newHttpClient();
    }

    public FilmsResponse fetchFilms(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if( response.statusCode() == 200 ){
                return gson.fromJson(response.body(), FilmsResponse.class );
            }
            return null;
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
