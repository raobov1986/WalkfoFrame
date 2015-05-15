package com.raoul.walkfoframe.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationBootReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED") ||
        		intent.getAction().equals("android.intent.action.QUICKBOOT_POWERON") ||
        		intent.getAction().equals("com.htc.intent.action.QUICKBOOT_POWERON")) {
        	Intent serviceIntent = new Intent(context, PushNotificationService.class);
        	context.startService(serviceIntent);
        }
    }
}
