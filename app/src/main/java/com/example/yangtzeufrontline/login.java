package com.example.yangtzeufrontline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class login extends Activity {
    private Button button;
    private TextView news_text;

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_slide,R.anim.out_right);
    }

    public void registe(){
        news_text = findViewById(R.id.news);
        news_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,Registe.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.from_right,R.anim.no_slide);
        setContentView(R.layout.login);

        registe();
    }
}
