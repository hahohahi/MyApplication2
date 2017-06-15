package com.example.leejaewon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<info> list;
    Intent intent;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,second.class);


        lv1 = (ListView)findViewById(R.id.listview);

        //ArrayList를 만들어 줍니다
        list = new ArrayList<info>();
        list.add(new info("01023213029","하이욥"));
        list.add(new info("01023213029","하이욥"));





        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendmessage messenger = new sendmessage(getBaseContext());
                messenger.sendMessageTo(list.get(position).getNum(),list.get(position).getS());
                Toast.makeText(getBaseContext(),list.get(position).getNum()+"님에게 "+list.get(position).getS()+"보냄",Toast.LENGTH_LONG).show();
            }
        });

        reciever re = new reciever();
    }




    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK) {

                startActivity(intent);

        }
        return true;
    }

    @Override
    public void onStart(){
        super.onStart();
        secondAdapter Adapter = new secondAdapter(list, this);
        lv1.setAdapter(Adapter);
    }


}
