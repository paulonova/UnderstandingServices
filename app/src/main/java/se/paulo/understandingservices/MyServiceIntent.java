package se.paulo.understandingservices;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/** * Created by Paulo Vila Nova on 2017-03-11.
 */

public class MyServiceIntent extends IntentService {


    public MyServiceIntent() {
        super("My_Worker_Thread");
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started..", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Stopping Service..", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        synchronized (this){
            int count = 0;
            while(count < 10){
                Log.d("COUNT", "count: " + count);
                try {
                    wait(1500);
                    count ++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }









}
