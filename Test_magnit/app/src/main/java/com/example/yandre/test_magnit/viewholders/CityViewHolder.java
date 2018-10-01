package com.example.yandre.test_magnit.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yandre.test_magnit.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityViewHolder extends GroupViewHolder {

    @BindView(R.id.cardCountryTitle) TextView cardCountryTitle;
    @BindView(R.id.cardIcArrow) ImageView cardIcArrow;

    public CityViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setCountryTitle(String CountryTitle) {
        cardCountryTitle.setText(CountryTitle);
    }
    public void getCountryTitle(){
        cardCountryTitle.getText();
    }
}
