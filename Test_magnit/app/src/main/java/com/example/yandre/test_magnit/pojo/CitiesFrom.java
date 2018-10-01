package com.example.yandre.test_magnit.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CitiesFrom {
    @SerializedName("citiesFrom")
    private List<City> cityFromList;

    public List<City> getCityFromList() {
        return cityFromList;
    }

    public void setCityFromList(List<City> cityFromList) {
        this.cityFromList = cityFromList;
    }
}
