package com.example.user.json1;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 26/1/2017.
 */

public class OpenJsonUtils {

    public static ArrayList<NewsConstant> getSimpleJson(Context context,String response){

        ArrayList<NewsConstant> item = new ArrayList<>();
        try {
            JSONObject root= new JSONObject(response);
            JSONObject data = root.getJSONObject("data");
            JSONArray children = data.getJSONArray("children");

            for (int i = 0; i < children.length(); i++) {
                JSONObject post = children.getJSONObject(i).getJSONObject("data");



                String title = post.getString("title");
                String thumb = post.getString("thumbnail");
                String rUrl =post.getString("url");
                String subred = post.getString("subreddit");
                String author = post.getString("author");


                item.add(new NewsConstant(title,thumb,rUrl,author));
                Log.e("the json","passed");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;

    }
}
