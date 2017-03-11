package se.paulo.understandingservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/** * Created by Paulo Vila Nova on 2017-03-11.
 */

public class MyService extends Service {


    final class MyThreadClass implements Runnable {

        int service_id;

        public MyThreadClass(int service_id) {
            this.service_id = service_id;
        }

        @Override
        public void run() {
            int i = 0;
            synchronized (this){

                while(i < 10){
                    try {
                        wait(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(service_id);
            }
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


    /**STARTS THE SERVICE*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Starting Service..", Toast.LENGTH_LONG).show();
        Thread thread = new Thread(new MyThreadClass(startId));
        thread.start();
        return START_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Stopping Service..", Toast.LENGTH_LONG).show();
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void testIfServiceWorks(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

    }


}
