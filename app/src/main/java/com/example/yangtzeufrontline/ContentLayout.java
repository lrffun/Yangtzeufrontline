package com.example.yangtzeufrontline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ContentLayout extends LinearLayout {
    public ContentLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.weibohome,this);
    }
}
