package com.example.user.json1;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


/**
 * Created by User on 23/1/2017.
 */

public class NetworkUtils {

    private static final String Base_url = "https://www.reddit.com";
    private static final String cat = "r";
    private static final String type="movies";
    private static final String format = ".json";




    public static URL address(){
        Uri build = Uri.parse(Base_url).buildUpon().appendPath(cat).appendPath(type).appendPath(format).build();

        URL  url = null;
        try{
            url = new URL(build.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.e("the Url:","Build url "+url);
        return url;

    }



    public static String makeHttpRequest(URL url) throws IOException{

        HttpURLConnection mOpenConnection = (HttpURLConnection)url.openConnection();
        try{
            InputStream inS = mOpenConnection.getInputStream();
            Scanner sc = new Scanner(inS);
            sc.useDelimiter("\\A");

            boolean hasInput = sc.hasNext();
            if(hasInput){
               return sc.next();
            }else{
                return null;
            }

        }finally {
            mOpenConnection.disconnect();
        }

    }

}
