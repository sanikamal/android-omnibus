package com.ruatech.sanikamal.startserviceonbootexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Sani Kamal on 04-Feb-18.
 */

public class ServiceStartOnBoot extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
// here you can add whatever you want this service to do
    }
}
