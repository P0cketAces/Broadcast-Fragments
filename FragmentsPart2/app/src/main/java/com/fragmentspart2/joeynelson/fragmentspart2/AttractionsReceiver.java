package com.fragmentspart2.joeynelson.fragmentspart2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Joey on 3/27/2018.
 */

public class AttractionsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Intent aIntent = new Intent(arg0, MainActivity.class);
        arg0.startActivity(aIntent);
    }
}