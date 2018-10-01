package com.example.yandre.test_magnit.shedule;

import com.example.yandre.test_magnit.pojo.CitiesFrom;
import com.example.yandre.test_magnit.pojo.RvCity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SheduleModel {

    CitiesFrom citiesFrom;
    BufferedReader br = null;

    public SheduleModel(CitiesFrom citiesFrom, BufferedReader br) throws IOException {
        this.citiesFrom = citiesFrom;
        this.br =br;
    }
    public CitiesFrom getCitiesFrom() throws IOException {
        //выгружаем cities_from.json в
        StringBuilder sb = new StringBuilder();
        {
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);

            Gson gson = new Gson();
            //Type founderListType = new TypeToken<ArrayList<City>>(){}.getType();
            citiesFrom = gson.fromJson(sb.toString(), CitiesFrom.class);

            if (br != null) {
                br.close(); // stop reading
            }
        }
        return citiesFrom;
    }
}




