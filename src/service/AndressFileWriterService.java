package service;

import com.google.gson.Gson;
import model.Andress;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AndressFileWriterService {
    public void andressWrite(Andress andress) {
        Gson gson = new Gson();

        try {
            FileWriter writer = new FileWriter(andress.cep() + ".json");
            writer.write(gson.toJson(andress));
            writer.close();

            FileReader reader = new FileReader(andress.cep() + ".json");
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
