package com.example.user.json1;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<NewsConstant>> {

    private RecyclerView mRecycler;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = (RecyclerView)findViewById(R.id.rec_view);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MyAdapter(this);
        mRecycler.setAdapter(mAdapter);

       getSupportLoaderManager().initLoader(0,null,this);
    }

    @Override
    public Loader<ArrayList<NewsConstant>> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<ArrayList<NewsConstant>>(this) {
            @Override
            protected void onStartLoading() {
                if(args != null){

                }else{

                    forceLoad();
                }
            }

            @Override
            public ArrayList<NewsConstant> loadInBackground() {

                URL url = NetworkUtils.address();
                String response = null;
                ArrayList<NewsConstant> item = null;
                try{
                  response =  NetworkUtils.makeHttpRequest(url);
                    item = OpenJsonUtils.getSimpleJson(MainActivity.this,response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return item;
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<NewsConstant>> loader, ArrayList<NewsConstant> data) {
        if(data!=null){
            mAdapter.setData(data);
        }else{
            Log.v("the data","error");
        }
        

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<NewsConstant>> loader) {


    }
}
