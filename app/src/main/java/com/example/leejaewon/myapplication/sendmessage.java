package com.example.leejaewon.myapplication;

import android.content.Context;
import android.telephony.SmsManager;

/**
 * Created by LeeJaeWon on 2017-06-16.
 */

public class sendmessage {
        private Context mContext;
        public sendmessage(Context mContext){
            this.mContext=mContext;
        }

        public void sendMessageTo(String phon,String massge){
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(phon,null,massge,null,null);
        }

}
