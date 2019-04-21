package com.tj.playstorecopycat;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tj.playstorecopycat.databinding.ActivityMainBinding;
import com.tj.playstorecopycat.datas.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<App> appList = new ArrayList<>();

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();

    }


    void fillApps() {

        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));

    }


}













