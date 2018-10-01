package com.example.yandre.test_magnit.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CitiesTo {
    @SerializedName("citiesTo")

    private List<City> cityToList;

    public List<City> getCityToyList() {
        return cityToList;
    }

    public void setCityToList(List<City> cityList) {
        this.cityToList = cityToList;
    }
}
