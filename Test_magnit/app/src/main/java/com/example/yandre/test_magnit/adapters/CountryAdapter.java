package com.example.yandre.test_magnit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.test_magnit.R;
import com.example.yandre.test_magnit.pojo.Station;
import com.example.yandre.test_magnit.viewholders.CityViewHolder;
import com.example.yandre.test_magnit.viewholders.StationViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class CountryAdapter extends ExpandableRecyclerViewAdapter<CityViewHolder, StationViewHolder> {

    Context mContext;
    public CountryAdapter(List<? extends ExpandableGroup> groups, Context mContext) {
        super(groups);
        this.mContext = mContext;
    }

    @Override
    public CityViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_countries, parent, false);
        return new CityViewHolder(itemView);
    }

    @Override
    public StationViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_stations, parent, false);
        return new StationViewHolder(itemView, mContext);    }

    @Override
    public void onBindChildViewHolder(StationViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Station station = (Station) group.getItems().get(childIndex);
        holder.setCardStationsTitle(station.getCityTitle(), station.getDistrictTitle(),
                station.getStationTitle(), station.getCountryTitle(), station.getPoint());
    }

    @Override
    public void onBindGroupViewHolder(CityViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setCountryTitle(group.getTitle());
    }
}
