package com.tj.playstorecopycat;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.tj.playstorecopycat.adapters.AppAdapter;
import com.tj.playstorecopycat.databinding.ActivityMainBinding;
import com.tj.playstorecopycat.datas.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppAdapter mAppAdapter;

    List<App> appList = new ArrayList<>();

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();

        mAppAdapter = new AppAdapter(MainActivity.this, appList);
        act.appRankListView.setAdapter(mAppAdapter);


//      Q1. 확인버튼이 눌리면 "확인버튼을 눌렀습니다." 라는 토스트를 띄워봅시다.

        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "확인버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();


//                확인 버튼만 있도록 AlertDialog.

                AlertDialog.Builder okAlert = new AlertDialog.Builder(MainActivity.this);
//                okAlert.setTitle("게임 추가 알림");
                okAlert.setMessage("임시 게임이 추가됩니다.");
                okAlert.setPositiveButton("확인", null);
                okAlert.show();


                appList.add(new App(10, "임시 게임", "미상", 4, 39800, false));
                mAppAdapter.notifyDataSetChanged();

//                Ex. 리스트에 앱이 6개 : 마지막꺼는 몇번?5
//                Ex. 리스트에 앱이 2개 : 마지막꺼는? 1번

                act.appRankListView.smoothScrollToPosition(appList.size()-1);

            }
        });


        act.appRankListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(MainActivity.this, String.format("%d번 줄 클릭", position), Toast.LENGTH_SHORT).show();

                App clickedAppData = appList.get(position);

                Intent intent = new Intent(MainActivity.this, AppDetailActivity.class);
//                intent.putExtra("제목", clickedAppData.title);
//                intent.putExtra("회사이름", clickedAppData.companyName);
                intent.putExtra("앱정보", clickedAppData);
                startActivity(intent);


            }
        });

        act.appRankListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(MainActivity.this, String.format("%d번 줄을 오래 누름", position), Toast.LENGTH_SHORT).show();


                final int finalPosition = position;

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("앱 삭제 확인");
                alert.setMessage("정말 이 앱을 삭제하시겠습니까?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        appList.remove(finalPosition);

                        mAppAdapter.notifyDataSetChanged();

                        Toast.makeText(MainActivity.this, "해당 앱이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", null);
                alert.show();



                return true;
            }
        });


    }


    void fillApps() {

        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));
        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));
        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));
    }


}













