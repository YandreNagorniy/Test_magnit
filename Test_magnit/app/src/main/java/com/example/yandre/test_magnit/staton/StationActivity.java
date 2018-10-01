package com.example.yandre.test_magnit.staton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yandre.test_magnit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationActivity extends AppCompatActivity {

    @BindView(R.id.statoinCountryTitle) TextView statoinCountryTitle;
    @BindView(R.id.statoinDistrictTitle) TextView statoinDistrictTitle;
    @BindView(R.id.statoinCityTitle) TextView statoinCityTitle;
    @BindView(R.id.statoinTitle) TextView statoinTitle;
    @BindView(R.id.statoinCoordinates) TextView statoinCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        ButterKnife.bind(this);

        //получаем интеет
        Intent intent = getIntent();
        //инициализируем вью этого активити
        statoinCityTitle.setText(intent.getStringExtra("cardCityTitle"));
        statoinDistrictTitle.setText(intent.getStringExtra("cardDistrictTitle"));
        statoinTitle.setText(intent.getStringExtra("cardStationTitle"));
        statoinCountryTitle.setText(intent.getStringExtra("cardCountryTitle"));
        statoinCoordinates.setText(intent.getStringExtra("cardPointTitle"));
    }
}
