package com.example.broadcast_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION = "";
    TextView textView;
    Button button;
    Receiver LocalListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtBroadcast);
        button = findViewById(R.id.btnBroadcast);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalListner = new Receiver();
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        this.registerReceiver(LocalListner,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(LocalListner);
    }

    public void btnBroadcast(View view){
        if(view.getId() == R.id.btnBroadcast){
            BackgroundServices.startAction(this.getApplicationContext());
        }
    }

    public void onClick(View view){
        if(view.getId() == R.id.btnBroadcast){
            BackgroundServices.startAction(this.getApplicationContext());
        }
    }

    public class Receiver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            String currentText = textView.getText().toString();
            String message = intent.getStringExtra("value");

            currentText += "\nReceive" + message;
            textView.setText(currentText);
        }
    }
}
