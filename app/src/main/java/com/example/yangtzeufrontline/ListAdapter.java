package com.example.yangtzeufrontline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private int ContentId;

    public ListAdapter(Context context,int textViewResourceId, List<Content> objects){
        super(context,textViewResourceId,objects);
        ContentId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Content con = (Content) getItem(position);      //获取当前项的ContentList实例
        View view;

        if(convertView == null)
        {
            view = LayoutInflater.from(getContext()).inflate(ContentId,null);
        }
        else
        {
            view = convertView;
        }

        TextView writer = view.findViewById(R.id.writer);             //先将每个控件拿出来
        TextView title = view.findViewById(R.id.title);
        TextView content = view.findViewById(R.id.content);
        TextView time = view.findViewById(R.id.time);

        title.setText(con.getTitle());
        content.setText(con.getContent_brief());
        writer.setText(con.getWriter());
        time.setText(con.getTime());
        return view;
    }

}
