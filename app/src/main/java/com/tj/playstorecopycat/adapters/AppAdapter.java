package com.tj.playstorecopycat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tj.playstorecopycat.R;
import com.tj.playstorecopycat.datas.App;

import java.util.List;

public class AppAdapter extends ArrayAdapter<App> {

    Context mContext;
    List<App> mList;
    LayoutInflater inf;

    public AppAdapter(Context context, List<App> list) {

        super(context, R.layout.app_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.app_list_item, null);
        }

//        실질적으로 상황에 맞게 머리를 써야하는 부분.

//        각 줄에 맞는 앱 데이터를 mList에서 추출.
        App appData = mList.get(position);

        TextView rankAndTitleTxt = row.findViewById(R.id.rankAndTitleTxt);
        TextView companyNameTxt = row.findViewById(R.id.companyNameTxt);
        TextView priceOrInstalledTxt = row.findViewById(R.id.priceOrInstalledTxt);


//        등수와 제목을 세팅.
        rankAndTitleTxt.setText(String.format("%d. %s", appData.rank, appData.title));
//        회사 이름은 가진 그대로 대입.
        companyNameTxt.setText(appData.companyName);
//        만약 설치가 되었다면?  설치된 항목
//        안되었다면? 가격을 띄워줌. 3,500,000원 의 양식.

        if (appData.isMine) {
//            내가 설치한 항목일 경우 설치한 항목 글자를 그대로 표시.
//            실제 코딩은 하지 않았음.

        }
        else {
//            설치하지 않은 경우.
//            String.format의 %,d 를 이용해 세자리마다 컴마 찍음.
            priceOrInstalledTxt.setText(String.format("%,d원", appData.price));
        }


        return row;
    }
}












