package com.example.yandre.test_magnit.shedule;

import com.example.yandre.test_magnit.pojo.CitiesFrom;
import com.example.yandre.test_magnit.pojo.RvCity;
import com.example.yandre.test_magnit.pojo.Station;

import java.util.ArrayList;
import java.util.List;

public class ShedulePresenter {

    CitiesFrom citiesFrom;
    List<RvCity> cityList;
    List<String> stationNameList;

    public ShedulePresenter(CitiesFrom citiesFrom, List<RvCity> cityList) {
        this.citiesFrom = citiesFrom;
        this.cityList = cityList;
    }

    public List<RvCity> getDataset() {
        cityList = new ArrayList<>();
        //получаем название текущей страны
        String currentCountreTitle = citiesFrom.getCityFromList().get(0).getCountryTitle();
        //получаем название новой  страны (для первого элемента будут одинаковыми)
        String newCountreTitle = citiesFrom.getCityFromList().get(0).getCountryTitle();
        //все станции страны
        List<Station> stationList = new ArrayList<>();


        stationNameList= new ArrayList<>();

        // просматриваем все объекты
        for (int i = 0; i < citiesFrom.getCityFromList().size(); i++) {

            //количество станций в городе
            int countStationsOfCity = citiesFrom.getCityFromList().get(i).getStations().size();

            //пробегаюсь по станциям города
            for (int j = 0; j < countStationsOfCity; j++) {

                Station station = new Station();
                //получаем нужную информацию о станции
                //знаю, что можно по другому, но я предпочел этот способ
                station.setCityTitle(citiesFrom.getCityFromList().get(i).getStations().get(j).getCityTitle());
                station.setDistrictTitle(citiesFrom.getCityFromList().get(i).getStations().get(j).getDistrictTitle());
                station.setStationTitle(citiesFrom.getCityFromList().get(i).getStations().get(j).getStationTitle());
                station.setCountryTitle(citiesFrom.getCityFromList().get(i).getStations().get(j).getCountryTitle());
                station.setPoint(citiesFrom.getCityFromList().get(i).getStations().get(j).getPoint());
                stationList.add(station);

                //сохраняем в листе названия станций
                stationNameList.add(citiesFrom.getCityFromList().get(i).getStations().get(j).getStationTitle());
            }

            //если это не последний объект
            if (i + 1 < citiesFrom.getCityFromList().size()) {

                //получение информации о стране следующего объекта
                String nextObj = citiesFrom.getCityFromList().get(i + 1).getCountryTitle();
                //если следом идет другая страна
                if (currentCountreTitle.equals(nextObj)) {
                    continue;
                } else {
                    cityList.add(new RvCity(currentCountreTitle, stationList));
                    currentCountreTitle = citiesFrom.getCityFromList().get(i + 1).getCountryTitle();
                    stationList = new ArrayList<>();
                    continue;
                }
                //если последний
            } else cityList.add(new RvCity(currentCountreTitle, stationList));
        }
        return cityList;
    }

    public List<String> getStationNameList() {
        return stationNameList;
    }
}
