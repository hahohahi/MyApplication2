package com.example.leejaewon.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by LeeJaeWon on 2017-06-14.
 */

public class second extends AppCompatActivity{
    private ListView lv;
    private Button bt_add;
    private EditText phone;
    private EditText say;
    private secondAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        lv = (ListView)findViewById(R.id.second_listview);
        bt_add = (Button)findViewById(R.id.second_bt_add);
        phone = (EditText)findViewById(R.id.second_phone);
        say = (EditText)findViewById(R.id.second_say);



        Adapter= new secondAdapter(MainActivity.list, getBaseContext());
        lv.setAdapter(Adapter);


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.list.remove(position);
                Adapter=new secondAdapter(MainActivity.list,getBaseContext());
                lv.setAdapter(Adapter);
                return false;
            }
        });

        bt_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String sphone = phone.getText().toString();
                String ssay=say.getText().toString();
                MainActivity.list.add(new info(sphone,ssay));
                Adapter=new secondAdapter(MainActivity.list,getBaseContext());
                lv.setAdapter(Adapter);


            }
        });


    }
    @Override
    public void onResume(){
        super.onResume();

    }

}
