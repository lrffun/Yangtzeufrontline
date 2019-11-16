package com.example.yangtzeufrontline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private void enterHome(){
        Timer time = new Timer();
        TimerTask tk = new TimerTask() {
            Intent intent = new Intent(MainActivity.this,WeiboHome.class);
            @Override
            public void run() {
                // TODO Auto-generated method stub

                startActivity(intent);
                finish();
            }
        };time.schedule(tk, 2500);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        enterHome();
    }
}
