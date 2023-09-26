package service;

import com.google.gson.Gson;
import model.Andress;

public class DataToAndressHandler {


    public Andress cepToAndress(String cep) {
        Gson gson = new Gson();
        Andress andress = gson.fromJson(cep, Andress.class);

        return andress;
    }
}
