import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilmsResponse {
    @SerializedName("results")
    private ArrayList<Film> films;

    public void showAllFilms(){
        for( Film film : films ){
            System.out.println(film.getTitle());
        }
    }
}
