import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {
    private Gson gson;

    public JsonFileWriter() {
        this.gson = new Gson();
    }
    public void writeToFile(String fileName, Object data){
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(gson.toJson(data));
            System.out.println("Archivo JSON creado correctamente: " + fileName);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

}
