package com.tj.playstorecopycat;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tj.playstorecopycat.databinding.ActivityFilterBinding;

public class FilterActivity extends AppCompatActivity {

    ActivityFilterBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_filter);

        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                결과를 저장해서, 필터 화면을 호출한 곳으로 돌아가도록.
//                1. 결과 저장
                int minRating = Integer.parseInt(act.minRatingEdt.getText().toString());

//                2. 메인화면으로 돌아가기. 새로 띄우는게 X, 이전 화면으로 돌아가기 => 지금 화면을 닫는다.
//                돌아가는 Intent는 new Intent() 안에 아무것도 넣지 않음.
                Intent resultIntent = new Intent();
//                결과 인텐트에 입력한 최소 평점을 첨부
                resultIntent.putExtra("최소평점", minRating);
//                finish 하기 전에 결과를 설정.
                setResult(RESULT_OK, resultIntent);
//                모든 설정이 끝났으니 이 화면을 닫는다.
                finish();

            }
        });

    }
}









