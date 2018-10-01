package com.example.yandre.test_magnit.shedule;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.yandre.test_magnit.R;
import com.example.yandre.test_magnit.adapters.CountryAdapter;
import com.example.yandre.test_magnit.pojo.CitiesFrom;
import com.example.yandre.test_magnit.pojo.RvCity;
import com.example.yandre.test_magnit.staton.StationActivity;
import com.example.yandre.test_magnit.ticket.TicketActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SheduleActivity extends AppCompatActivity {
    @BindView(R.id.sheduleTime) TextView sheduleTime;
    @BindView(R.id.sheduleDate) TextView sheduleDate;
    @BindView(R.id.sheduleRv) RecyclerView sheduleRv;
    @BindView(R.id.autoCompileStationFrom) AutoCompleteTextView autoCompileStationFrom;
    @BindView(R.id.autoCompileStationTo) AutoCompleteTextView autoCompileStationTo;

    public Calendar dateTime = Calendar.getInstance();
    int hour, minute, day, month, year;
    String selectedHour = "";
    String selectedMinute = "";
    private CountryAdapter countryAdapter;
    private List<RvCity> cityList;
    CitiesFrom citiesFrom;
    private ArrayAdapter autoCompileAdapter;
    List<String> stationNameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedule);
        ButterKnife.bind(this);

        //считываем в буфер файл.json
        BufferedReader br2 = null;
        try {
            br2 = new BufferedReader(new InputStreamReader(getAssets().open(
                    "cities/cities_from.json")));

            SheduleModel model = new SheduleModel(citiesFrom, br2);
            citiesFrom = model.getCitiesFrom();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ShedulePresenter presenter = new ShedulePresenter(citiesFrom, cityList);
        // получим данные из презентера
        cityList = presenter.getDataset();

        stationNameList = new ArrayList<>();
        stationNameList = presenter.getStationNameList();
        autoCompileAdapter = new ArrayAdapter<>(SheduleActivity.this,
                android.R.layout.select_dialog_item, stationNameList);
        autoCompileStationFrom.setAdapter(autoCompileAdapter);
        //с первой буквы поиск
        autoCompileStationFrom.setThreshold(0);
        autoCompileStationTo.setAdapter(autoCompileAdapter);
        autoCompileStationTo.setThreshold(0);

        countryAdapter = new CountryAdapter(cityList, this);
        sheduleRv.setLayoutManager(new LinearLayoutManager(SheduleActivity.this));
        sheduleRv.setAdapter(countryAdapter);
    }

    // установка времени и даты
    @OnClick({R.id.linLayTime, R.id.linLayDate, R.id.selectBtn})
    void onClick(View view) {
        switch (view.getId()) {
            //установка времени
            case R.id.linLayTime: {
                hour = dateTime.get(Calendar.HOUR_OF_DAY);
                minute = dateTime.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfDay) {
                                if (hourOfDay < 10)
                                    selectedHour = "0" + hourOfDay;
                                else selectedHour = String.valueOf(hourOfDay);
                                if (minuteOfDay < 10)
                                    selectedMinute = "0" + minuteOfDay;
                                else selectedMinute = String.valueOf(minuteOfDay);
                                sheduleTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
            break;
            //установка даты
            case R.id.linLayDate: {
                day = dateTime.get(Calendar.DAY_OF_MONTH);
                month = dateTime.get(Calendar.MONTH);
                year = dateTime.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                if (monthOfYear < 9)
                                    sheduleDate.setText(dayOfMonth + ".0" + (monthOfYear + 1) + "." + year);
                                else
                                    sheduleDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                                if (dayOfMonth < 9)
                                    sheduleDate.setText( "0"+dayOfMonth +"." + (monthOfYear + 1) + "." + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            } break;
            case R.id.selectBtn: {

             String a =   String.valueOf(autoCompileStationFrom.getText());
              String b =  String.valueOf(autoCompileStationTo.getText());

                if(!a.equals("") && !b.equals("")) {
                    Intent intent = new Intent(this, TicketActivity.class);
                    intent.putExtra("autoCompileStationFrom", String.valueOf(autoCompileStationFrom.getText()));
                    intent.putExtra("autoCompileStationTo", String.valueOf(autoCompileStationTo.getText()));
                    intent.putExtra("time", String.valueOf(sheduleTime.getText()));
                    intent.putExtra("date", String.valueOf(sheduleDate.getText()));
                    startActivity(intent);
                }
                else Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        countryAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        countryAdapter.onRestoreInstanceState(savedInstanceState);
    }
}

