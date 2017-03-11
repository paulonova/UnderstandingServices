package se.paulo.understandingservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.button);
        stopBtn = (Button)findViewById(R.id.button2);

    }


    public void startService(View v){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopService(View v){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);

    }


}
