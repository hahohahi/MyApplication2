package com.example.leejaewon.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LeeJaeWon on 2017-06-15.
 */

public class secondAdapter extends ArrayAdapter<info> {
    private ArrayList<info> arrayList;
    Context context;
    int i;

    private static class sViewholder{
        TextView t_num;
        TextView t_s;
        TextView number;

    }

    public secondAdapter(ArrayList<info> data,Context context){
        super(context,R.layout.item,data);
        arrayList=data;
        this.context=context;
        i=1;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //아이템을 받아옵니다

        final info dataModel = getItem(position);
        //viewholder는 해당 view에 대한 객체를 가지고 cache를 저장한 후에 재사용을 하게 됩니다
        secondAdapter.sViewholder viewHolder;

        final View result;

        //첫 아이템을 생성해주거나 할때는 converview가 비어있게 됩니다 만약 비어있을 경우에만
        //view들을 새롭게 생성해주고 그렇지 않으면 tag에 저장된 값을 재사용합니다
        if (convertView == null) {

            viewHolder = new secondAdapter.sViewholder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.t_num = (TextView) convertView.findViewById(R.id.aa);
            viewHolder.t_s = (TextView) convertView.findViewById(R.id.bb);
            viewHolder.number=(TextView)convertView.findViewById(R.id.number);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (secondAdapter.sViewholder) convertView.getTag();
            result=convertView;
        }

        viewHolder.t_num.setText(dataModel.getNum());
        viewHolder.t_s.setText(dataModel.getS());
        Log.i("position",String.valueOf(position));
        if(viewHolder.number.getText().toString().equals("")) {
            viewHolder.number.setText(String.valueOf(i++));
        }
        return convertView;
    }



}
