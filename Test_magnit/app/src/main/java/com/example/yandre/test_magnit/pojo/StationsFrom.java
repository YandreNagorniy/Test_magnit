package com.example.yandre.test_magnit.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationsFrom {
    @SerializedName("stations")
    private List<Station> stations;

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
