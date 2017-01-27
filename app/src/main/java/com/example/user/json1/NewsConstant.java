package com.example.user.json1;

/**
 * Created by User on 23/1/2017.
 */

public class NewsConstant {

    private String title;

    private String ThumbUrl;
    private String mUrl;
    private String Author;
    public NewsConstant(String title,String ThumbUrl,String url,String Author){

    }

    public String getThumbUrl() {
        return ThumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        ThumbUrl = thumbUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String section) {
        this.Author = section;
    }
}
