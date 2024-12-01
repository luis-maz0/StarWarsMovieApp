import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String direccion = "https://swapi.dev/api/films/";
        FilmsResponse films = null;
        Gson gson = new Gson();
        do{
            System.out.println("Ingrese la opción de consulta: ");
            System.out.println("1. Ver todos los films:");
            System.out.println("2. Crear archivo JSON con todos los films");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    //1. Crear Cliente HTTP (Hace peticiones al servidor)
                    HttpClient client = HttpClient.newHttpClient();

                    //2. Crear solicitud o petición
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(direccion))
                            .GET()
                            .build();
                    //3. Enviar solicitud y recibir la respuesta
                    HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString());

                    //4. Mostrar los datos y el estado de la respuesta
                    System.out.println("Estado: "+ response.statusCode());
                    System.out.println("Cuerpo respuesta: "+ response.body());

                    //5. Convertir la respuesta JSON a una clase
                    String json = response.body();
                    films = gson.fromJson(json, FilmsResponse.class);
                    films.showAllFilms();
                    break;
                case 2:
                    FileWriter archivo = new FileWriter("films.json");
                    archivo.write(gson.toJson(films));
                    archivo.close();
                    break;
            }
        }while (opcion != 5);
    }
}