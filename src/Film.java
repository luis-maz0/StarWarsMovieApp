import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Film {
    private String title;
    @SerializedName("episode_id")
    private int id;
    private String release_date;

    @Override
    public String toString() {
        return "Film data{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}
