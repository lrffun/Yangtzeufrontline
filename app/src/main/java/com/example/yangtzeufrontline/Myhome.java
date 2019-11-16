package com.example.yangtzeufrontline;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public class Myhome extends Activity {

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_slide,R.anim.out_right);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.from_right,R.anim.no_slide);
        setContentView(R.layout.login);
    }
}
