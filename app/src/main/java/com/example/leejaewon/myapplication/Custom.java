package com.example.leejaewon.myapplication;

import android.content.Context;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by LeeJaeWon on 2017-05-26.
 */

public class Custom extends ArrayAdapter<info> {
    private ArrayList<info> arrayList;
    Context context;
    int i =1;

    private static class Viewholder{
        TextView t_num;
        TextView t_s;
        TextView number;

    }

    public Custom(ArrayList<info> data,Context context){
        super(context,R.layout.item,data);
        arrayList=data;
        this.context=context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //아이템을 받아옵니다

        final info dataModel = getItem(position);
        //viewholder는 해당 view에 대한 객체를 가지고 cache를 저장한 후에 재사용을 하게 됩니다
        Viewholder viewHolder;

        final View result;

        //첫 아이템을 생성해주거나 할때는 converview가 비어있게 됩니다 만약 비어있을 경우에만
        //view들을 새롭게 생성해주고 그렇지 않으면 tag에 저장된 값을 재사용합니다
        if (convertView == null) {

            viewHolder = new Viewholder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.t_num = (TextView) convertView.findViewById(R.id.aa);
            viewHolder.t_s = (TextView) convertView.findViewById(R.id.bb);
            viewHolder.number=(TextView)convertView.findViewById(R.id.number);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Viewholder) convertView.getTag();
            result=convertView;
        }

        viewHolder.t_num.setText(dataModel.getNum());
        viewHolder.t_s.setText(dataModel.getS());
        viewHolder.number.setText(String.valueOf(i++));


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Messenger messenger = new Messenger(context);
                messenger.sendMessageTo(dataModel.getNum(),dataModel.getS());
                Toast.makeText(context,dataModel.getNum()+"님에게 "+dataModel.getS()+"보냄",Toast.LENGTH_LONG).show();
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }

    public class Messenger{
        private Context mContext;
        public Messenger(Context mContext){
            this.mContext=mContext;
        }

        public void sendMessageTo(String phon,String massge){
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(phon,null,massge,null,null);
        }
    }


}
