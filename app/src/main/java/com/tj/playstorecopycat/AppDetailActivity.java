package com.tj.playstorecopycat;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.tj.playstorecopycat.databinding.ActivityAppDetailBinding;
import com.tj.playstorecopycat.datas.App;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppDetailActivity extends AppCompatActivity {

    App mAppData; // 이 화면에서 다룰 앱의 정보를 가진 멤버변수

    ActivityAppDetailBinding act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_app_detail);


//        String appTitle = getIntent().getStringExtra("제목");
//        String appCompanyName = getIntent().getStringExtra("회사이름");

        mAppData = (App) getIntent().getSerializableExtra("앱정보");


        act.appTitleTxt.setText(mAppData.title);
        act.companyNameTxt.setText(mAppData.companyName);

        act.userRatingTxt.setText(String.format("%d점", mAppData.userRating));

//        구매 여부에 따라 필요한 버튼만 보여주기

        if (mAppData.isMine) {
            act.removeBtn.setVisibility(View.VISIBLE);
            act.launchBtn.setVisibility(View.VISIBLE);
            act.purchaseBtn.setVisibility(View.GONE);
        }
        else {
            act.removeBtn.setVisibility(View.GONE);
            act.launchBtn.setVisibility(View.GONE);
            act.purchaseBtn.setVisibility(View.VISIBLE);

//            구매하기 버튼의 문구도 올바른 가격으로
            act.purchaseBtn.setText(String.format("구매하기(%,d원)", mAppData.price));

        }

        act.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri phoneUri = Uri.parse("tel:010-9876-5432");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
                startActivity(intent);

            }
        });

        act.smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri smsUri = Uri.parse("smsto:01012345678");
                Intent intent = new Intent(Intent.ACTION_SENDTO, smsUri);
                intent.putExtra("sms_body", "미리 작성될 메세지");
                startActivity(intent);
            }
        });


        act.dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("텍스트뷰클릭!", "실제로 동작하나?");

                DatePickerDialog dpd = new DatePickerDialog(AppDetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

//                        Toast.makeText(AppDetailActivity.this, String.format("%d년 %d월 %d일", year, month, dayOfMonth), Toast.LENGTH_SHORT).show();

                        Calendar cal = Calendar.getInstance(); // new Calendar라고 만들지 않는다. 싱글턴 패턴의 일종

//                        1. 항목별로 어떤값을 갖게할건지? 코딩 방식
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, month);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

//                        2. 년/월/일을 한꺼번에 세팅.
                        cal.set(year, month, dayOfMonth);

//                        같은 메쏘드인데, arg 의 종류/갯수에 따라 다른 행동을함. => overloading 의 예시.


//                        cal에 저장된 값을 String으로 (양식에 맞게) 바꿔서 TextView에 세팅.
//                        날짜를 양식으로 바꾸고 싶을때 : SimpleDateFormat을 사용.

//                        어떤 양식으로 문자를 출력할지 지정. 양식 지정.
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일");

//                        지정된 양식을 통해 Calendar 변수를 String으로 변환.
                        String dateStr = sdf.format(cal.getTimeInMillis());

//                        만들어진 String을 화면에 출력.
                        act.dateTxt.setText(dateStr);




                    }
                }, 2019, 3, 27);

                dpd.show();

            }
        });


        act.timeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(AppDetailActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        cal.set(Calendar.MINUTE, minute);

                        SimpleDateFormat sdf = new SimpleDateFormat("a h시 m분", Locale.KOREA);

                        String timeStr = sdf.format(cal.getTimeInMillis());

                        act.timeTxt.setText(timeStr);

                    }
                }, 3, 15, true);

                tpd.show();
            }
        });


    }
}












