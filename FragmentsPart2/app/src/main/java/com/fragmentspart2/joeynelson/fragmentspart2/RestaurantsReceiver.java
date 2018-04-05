package com.fragmentspart2.joeynelson.fragmentspart2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Joey on 3/27/2018.
 */

public class RestaurantsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Intent rIntent = new Intent(arg0, Main2Activity.class);
        arg0.startActivity(rIntent);
    }
}
