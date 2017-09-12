package com.aaron.client;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;


public class MyService extends Service {
    String aString;
    public MyService(String passed) {
        aString = passed;
    }

    @Override
    public IBinder onBind(Intent intent) {
        final ResultReceiver rec = (ResultReceiver) intent.getParcelableExtra("rec");
        return new IMyAidlInterface.Stub() {
            @Override
            public String getPojo() throws RemoteException {
                return aString;
            }
        };


        }



}
