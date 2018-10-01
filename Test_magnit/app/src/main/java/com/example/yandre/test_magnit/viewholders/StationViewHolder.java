package com.example.yandre.test_magnit.viewholders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yandre.test_magnit.R;
import com.example.yandre.test_magnit.pojo.Coordinates;
import com.example.yandre.test_magnit.shedule.SheduleActivity;
import com.example.yandre.test_magnit.staton.StationActivity;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationViewHolder extends ChildViewHolder implements View.OnClickListener {
    //находим элементы в card_station
    @BindView(R.id.cardCityTitle) TextView cardCityTitle;
    @BindView(R.id.cardDistrictTitle) TextView cardDistrictTitle;
    @BindView(R.id.cardStationTitle) TextView cardStationTitle;
    @BindView(R.id.cardCountryTitle) TextView cardCountryTitle;
    @BindView(R.id.cardCoordinateTitle) TextView cardCoordinateTitle;
    @BindView(R.id.cardViewStation) CardView cardViewStation;
    Context mContext;

    public StationViewHolder(View itemView, Context mContext) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mContext = mContext;
        cardViewStation.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    public void setCardStationsTitle(String cityTitle, String districtTitle, String stationTitle,
                                     String countryTitle, Coordinates pointTitle) {
        //инициализируем элемнты card_station
        cardCityTitle.setText(cityTitle);
        cardDistrictTitle.setText(districtTitle);
        cardStationTitle.setText(stationTitle);
        cardCountryTitle.setText(countryTitle);
        String x = String.valueOf(pointTitle.getLongitude());
        String y = String.valueOf(pointTitle.getLatitude());
        cardCoordinateTitle.setText(x+"\n"+y);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            switch (v.getId()) {
                case R.id.cardViewStation:
                    goToStationActivity(position);
            }
        }
    }

    private void goToStationActivity(int position) {
        //отправляем интентом значения в activity_station
        Intent intent = new Intent(mContext, StationActivity.class);
        intent.putExtra("cardCityTitle", cardCityTitle.getText());
        intent.putExtra("cardDistrictTitle", cardDistrictTitle.getText());
        intent.putExtra("cardStationTitle", cardStationTitle.getText());
        intent.putExtra("cardCountryTitle", cardCountryTitle.getText());
        intent.putExtra("cardPointTitle", cardCoordinateTitle.getText());
        mContext.startActivity(intent);
    }
}

