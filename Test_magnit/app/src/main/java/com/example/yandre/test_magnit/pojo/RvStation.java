package com.example.yandre.test_magnit.pojo;

public class RvStation {

    private String cityTitle;
    private String districtTitle;
    private String stationTitle;

    public RvStation(String cityTitle, String districtTitle, String stationTitle) {
        this.cityTitle = cityTitle;
        this.districtTitle = districtTitle;
        this.stationTitle = stationTitle;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public String getDistrictTitle() {
        return districtTitle;
    }

    public String getStationTitle() {
        return stationTitle;
    }
}
