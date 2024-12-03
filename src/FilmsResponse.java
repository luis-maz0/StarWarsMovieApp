import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilmsResponse {
    @SerializedName("results")
    private ArrayList<Film> films;

    public void showAllFilms() {
        if (films == null || films.isEmpty()) {
            System.out.println("No hay films disponibles.");
        } else {
            for (int i = 0; i < films.size(); i++) {
                System.out.println((i + 1) + " - " + films.get(i));
            }
        }
    }
}
