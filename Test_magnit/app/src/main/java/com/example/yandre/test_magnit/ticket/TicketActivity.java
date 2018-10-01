package com.example.yandre.test_magnit.ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yandre.test_magnit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TicketActivity extends AppCompatActivity {

    @BindView(R.id.statoinFromName) TextView statoinFromName;
    @BindView(R.id.statoinToName) TextView statoinToName;
    @BindView(R.id.tvTime) TextView tvTime;
    @BindView(R.id.tvDate) TextView tvDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        //инициализируем вью этого активити
        statoinFromName.setText(intent.getStringExtra("autoCompileStationFrom"));
        statoinToName.setText(intent.getStringExtra("autoCompileStationTo"));
        tvTime.setText(intent.getStringExtra("time"));
        tvDate.setText(intent.getStringExtra("date"));

    }
}
