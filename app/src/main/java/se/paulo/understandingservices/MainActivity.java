package se.paulo.understandingservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn;
    EditText getMessageEdt;
    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myService = new MyService();

        startBtn = (Button)findViewById(R.id.button);
        stopBtn = (Button)findViewById(R.id.button2);
        getMessageEdt = (EditText)findViewById(R.id.editText);

    }


    public void startService(View v){
        Intent intent = new Intent(this, MyServiceIntent.class);
        startService(intent);
    }

    public void stopService(View v){
        Intent intent = new Intent(this, MyServiceIntent.class);
        stopService(intent);

    }

//    public void getMessage(View v){
//        myService.testIfServiceWorks(getMessageEdt.getText().toString());
//
//    }




}
