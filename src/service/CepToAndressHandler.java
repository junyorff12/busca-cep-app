package service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Andress;

public class CepToAndressHandler {


    public Andress cepToAndress(String cep) {
        Gson gson = new Gson();
        Andress andress = gson.fromJson(cep, Andress.class);

        return andress;
    }
}
