package com.example.yangtzeufrontline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;


public class Details extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.details);
        TextView title = findViewById(R.id.details_title);
        TextView content = findViewById(R.id.details_content);
        Intent intent = getIntent();
        String in_title = intent.getStringExtra("in_title");
        String in_content= intent.getStringExtra("in_content");
        title.setText(in_title);
        content.setText(in_content);
    }
}
