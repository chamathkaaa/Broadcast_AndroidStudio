package com.example.broadcast_androidstudio;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class BackgroundServices extends IntentService {

    public BackgroundServices(){
        super("BackgroundServices");
    }

    public static  void startAction(Context context){
        Intent intent = new Intent(context,BackgroundServices.class);
        context.startActivities(new Intent[]{intent});
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            for (int i = 0; i < 20; i++) {
                Intent LocalBroadcastIntent = new Intent(MainActivity.BROADCAST_ACTION);
                LocalBroadcastIntent.putExtra("value", "Broadcast" + (i + 1));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendBroadcast(LocalBroadcastIntent);
            }

        }
    }
}
