package com.example.yandre.test_magnit.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yandre.test_magnit.R;
import com.example.yandre.test_magnit.info.InfoActivity;
import com.example.yandre.test_magnit.shedule.SheduleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.linLayShedule) LinearLayout linLayShedule;
    @BindView(R.id.linLayInfo) LinearLayout linLayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.linLayShedule, R.id.linLayInfo})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.linLayShedule: {
                Intent intent = new Intent(this, SheduleActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.linLayInfo: {
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
