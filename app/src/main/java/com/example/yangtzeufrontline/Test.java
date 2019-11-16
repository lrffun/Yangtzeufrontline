package com.example.yangtzeufrontline;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test{
    private String urlstr = "http://120.78.87.135:8000/blog/";
    Content content;

    protected void get() {
        try{
            URL url = new URL(urlstr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String sread = null;
            StringBuffer buffer1 = new StringBuffer();
            while((sread = buffer.readLine())!=null){
                buffer1.append(sread);
                buffer1.append("\r\n");
            }
            String result = buffer1.toString();
            Gson gson = new Gson();
            content = gson.fromJson(result,Content.class);
        }catch (MalformedURLException m){
        }catch (IOException io){}
    }

    public Content getContent(){
        get();
        return content;
    }
}
