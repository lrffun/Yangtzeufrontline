package com.example.yangtzeufrontline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Search extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        final EditText editText = findViewById(R.id.Search_IN);
        Button button = findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                    //点击按钮后，得到写入内容传入上一个活动
               Intent intent = new Intent();
               String in = editText.getText().toString();
               intent.putExtra("search_return",in);
               setResult(RESULT_OK,intent);
               finish();
            }
        });
    }
}
