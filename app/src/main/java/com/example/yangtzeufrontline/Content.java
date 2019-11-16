package com.example.yangtzeufrontline;

public class Content {
    private String title;
    private String writer;
    private String content_brief;
    private String content;
    private String time;

    public Content(String title,String writer,String content,String time){
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.time = time;
        content_brief = content.substring(0,20);
    }
    public String getContent_brief(){ return content_brief;}

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }
}
