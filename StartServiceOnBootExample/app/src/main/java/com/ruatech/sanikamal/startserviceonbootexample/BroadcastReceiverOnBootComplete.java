package com.ruatech.sanikamal.startserviceonbootexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Sani Kamal on 04-Feb-18.
 */

public class BroadcastReceiverOnBootComplete extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(intent.ACTION_BOOT_COMPLETED)) {
            Intent serviceIntent = new Intent(context, ServiceStartOnBoot.class);
            context.startService(serviceIntent);
        }

    }
}
