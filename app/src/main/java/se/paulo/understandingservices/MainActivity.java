package se.paulo.understandingservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn, firstMsgBtn, secondMsgBtn;
    EditText getMessageEdt;
    MyBoundService myBoundService;
    boolean isBind = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.button);
        stopBtn = (Button)findViewById(R.id.button2);
        firstMsgBtn = (Button)findViewById(R.id.button3);
        secondMsgBtn = (Button)findViewById(R.id.button4);
        getMessageEdt = (EditText)findViewById(R.id.editText);

        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

    }


    public void startService(View v){
        Intent intent = new Intent(this, MyServiceIntent.class);
        startService(intent);
    }

    public void stopService(View v){
        Intent intent = new Intent(this, MyServiceIntent.class);
        stopService(intent);

    }


    public void getFirstMessage(View v){
        String message = myBoundService.getFirstMessage();
        getMessageEdt.setText(message);

    }


    public void getSecondMessage(View v){
        String message = myBoundService.getSecondMessage();
        getMessageEdt.setText(message);
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {

            MyBoundService.LocalService localService = (MyBoundService.LocalService) service;
            myBoundService = localService.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBind=false;
        }
    };


    @Override
    protected void onStop() {
        super.onStop();
        if(isBind){
            unbindService(mConnection);
            isBind=false;
        }
    }
}
