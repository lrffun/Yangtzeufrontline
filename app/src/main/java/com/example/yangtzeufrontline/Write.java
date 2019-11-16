package com.example.yangtzeufrontline;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class Write extends Activity {
    private String in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);

        final EditText editText = findViewById(R.id.write_text);
        Button button = findViewById(R.id.write_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                    //点击按钮后，得到搜索内容传入上一个活动
                Intent intent = new Intent();
                in = editText.getText().toString();
                setResult(RESULT_OK,intent);
                intent.putExtra("write_return",in);
                finish();
            }
        });
    }
}
