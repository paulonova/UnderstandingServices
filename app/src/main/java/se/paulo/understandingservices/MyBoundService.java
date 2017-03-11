package se.paulo.understandingservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/** * Created by Paulo Vila Nova on 2017-03-11.
 */

public class MyBoundService extends Service {

    private final IBinder mIBinder = new LocalService();


    public String getFirstMessage(){
        return "This is the First message..";
    }

    public String getSecondMessage(){
        return "This is Bound Service Example..";
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }




   public class LocalService extends Binder{

        MyBoundService getService(){



            return MyBoundService.this;
        }


    }





}
