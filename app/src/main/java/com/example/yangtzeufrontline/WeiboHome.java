package com.example.yangtzeufrontline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

//import androidx.annotation.Nullable;        //@Nullable 表示可以传入空的参数；

public class WeiboHome extends Activity implements  View.OnClickListener{       //微博主页活动
    private Button search_button;
    private Button hot_button;
    private Button write_button;
    private Button myhome_button;
    private LinearLayout top;
    private LinearLayout bottom;
    private List<Content> contentList = new ArrayList<Content>();

   @Override
    public void onClick(View v){                                                //接收按钮输入
        switch(v.getId())
        {
            case R.id.write:{
                Intent write = new Intent(WeiboHome.this,Write.class);
                startActivityForResult(write,2);
            }break;

            case R.id.Search:{
                Intent search = new Intent(WeiboHome.this,Search.class);
                startActivityForResult(search,1);
            }break;

            case R.id.hot:{
                Toast.makeText(WeiboHome.this,"你点击了热门",Toast.LENGTH_SHORT).show();
            }break;

            case R.id.myhome:{
                Intent myhome = new Intent(WeiboHome.this,login.class);
                startActivity(myhome);
            }break;
            default:{
                Toast.makeText(WeiboHome.this,"别乱点哦",Toast.LENGTH_SHORT).show();
            }

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {     //接收别的活动传过来的数据
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:if(resultCode == RESULT_OK){
                String searchReturn = data.getStringExtra("search_return");
                Toast.makeText(WeiboHome.this,searchReturn,Toast.LENGTH_SHORT).show();
            }
            case 2:if(resultCode == RESULT_OK){
                String writeReturn = data.getStringExtra("write_return");
                Toast.makeText(WeiboHome.this,writeReturn,Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void mylayout(){
       top = findViewById(R.id.top);
       bottom = findViewById(R.id.bottom);
       top.getBackground().setAlpha(60);
       bottom.getBackground().setAlpha(60);
    }

    public void myButton(){                 //按钮
        search_button = findViewById(R.id.Search);
        search_button.setOnClickListener(this);
        hot_button = findViewById(R.id.hot);
        hot_button.setOnClickListener(this);
        hot_button.getBackground().setAlpha(255);
        hot_button.getBackground().setAlpha(0);
        write_button = findViewById(R.id.write);
        write_button.setOnClickListener(this);
        myhome_button=findViewById(R.id.myhome);
        myhome_button.setOnClickListener(this);

    }

    public void Spinner(){              //选择框

        Spinner spinner = findViewById(R.id.Spinner);                               //将控件实例化
        final String[] arr = {"推荐","科技","军事","娱乐","搞笑","校园"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item_text,arr);      //Spinner显示
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {                                //接收Spinner输入
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(WeiboHome.this, "点击了" + arr[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void inits(){
       String content = "金大使在致辞中感谢芒果卫视与冰岛促进局举办这一有意义的活动，祝贺四位中国演员成功完成了在冰岛的“碳中和”之旅，期待他们能在促进中冰人文交流和环保领域继续发挥积极作用。他表示，中国政府一贯重视环境保护，积极参与应对气变的国际合作，认真履行《巴黎协定》承诺。冰岛政府亦将环保、应对气变作为首要施政重点，中冰两国在该领域有着共同利益和广阔合作空间。期待着节目的播出能吸引更多中国游客访冰，进一步推动中冰人文交流蓬勃发展。";
        for (int i = 0;i < 10;i++){
            Content con = new Content("标题：第"+i+"个","发表人:张"+i,content,"时间：2019/11/"+i);
            contentList.add(con);
        }
        Test test = new Test();
       // contentList.add(test.getContent());
    }

    public void initList(){
        final ListView listView = findViewById(R.id.listView);
        inits();
        ListAdapter adapter = new ListAdapter(WeiboHome.this,R.layout.list,contentList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Content content = contentList.get(i);
                Intent intent = new Intent(WeiboHome.this,Details.class);
                intent.putExtra("in_title",content.getTitle());
                intent.putExtra("in_content",content.getContent());
                startActivity(intent);
            }
        });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {                               //活动主进程
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weibohome);

        myButton();         //按钮

        Spinner();          //选择框

        initList();         //内容
    }

}
