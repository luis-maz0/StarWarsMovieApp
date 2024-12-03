import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String url = "https://swapi.dev/api/films/";
        ApiService apiService = new ApiService(url);
        JsonFileWriter fileWriter = new JsonFileWriter();
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    FilmsResponse films = apiService.fetchFilms();
                    if( films != null){
                        films.showAllFilms();
                    }
                    break;
                case 2:
                    FilmsResponse filmsToSave = apiService.fetchFilms();
                    if( filmsToSave != null){
                        fileWriter.writeToFile("films.json", filmsToSave);
                    }
            }
        }while (opcion != 5);
    }

    public static void mostrarMenu(){
        System.out.println("Ingrese la opción de consulta:");
        System.out.println("1. Ver todos los films");
        System.out.println("2. Crear archivo JSON con todos los films");
        System.out.println("5. Salir");
    }
}