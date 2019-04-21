package com.tj.playstorecopycat;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tj.playstorecopycat.databinding.ActivityAppDetailBinding;

public class AppDetailActivity extends AppCompatActivity {

    ActivityAppDetailBinding act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_app_detail);


        String appTitle = getIntent().getStringExtra("제목");
        String appCompanyName = getIntent().getStringExtra("회사이름");

        act.appTitleTxt.setText(appTitle);
        act.companyNameTxt.setText(appCompanyName);


    }
}
