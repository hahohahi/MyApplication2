package com.example.leejaewon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<info> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv1 = (ListView)findViewById(R.id.listview);

        //ArrayList를 만들어 줍니다
        list = new ArrayList<info>();
        list.add(new info("01023213029","하이욥"));
        list.add(new info("01023213029","하이욥"));



        Custom Adapter = new Custom(list, this);
        lv1.setAdapter(Adapter);

        reciever re = new reciever();
    }


    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(getBaseContext(),second.class);
            startActivity(intent);

        }
        return true;
    }


}
