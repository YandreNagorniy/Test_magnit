package com.example.yandre.test_magnit.pojo;

import com.example.yandre.test_magnit.pojo.Coordinates;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {
    @SerializedName("countryTitle")
    private String countryTitle;
    @SerializedName("point")
    private Coordinates point;
    @SerializedName("districtTitle")
    private String districtTitle;
    @SerializedName("cityId")
    private int cityId;
    @SerializedName("cityTitle")
    private String cityTitle;
    @SerializedName("regionTitle")
    private String regionTitle;
    @SerializedName("stationId")
    private int stationId;
    @SerializedName("stationTitle")
    private String stationTitle;

    public String getCountryTitle() {
        return countryTitle;
    }

    public void setCountryTitle(String countryTitle) {
        this.countryTitle = countryTitle;
    }

    public Coordinates getPoint() {
        return point;
    }

    public void setPoint(Coordinates point) {
        this.point = point;
    }

    public String getDistrictTitle() {
        return districtTitle;
    }

    public void setDistrictTitle(String districtTitle) {
        this.districtTitle = districtTitle;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getRegionTitle() {
        return regionTitle;
    }

    public void setRegionTitle(String regionTitle) {
        this.regionTitle = regionTitle;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public void setStationTitle(String stationTitle) {
        this.stationTitle = stationTitle;
    }

}
