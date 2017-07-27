package com.mirza.avantari.retrofit_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mirza.avantari.retrofit_demo.Model.User;
import com.mirza.avantari.retrofit_demo.Rest.ApiClient;
import com.mirza.avantari.retrofit_demo.Rest.RetrofitArrayAPI;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        RecyclerView.setLayoutManager(mLayoutManager);

        getRetrofitArray();
    }


    public void getRetrofitArray() {

        RetrofitArrayAPI service = ApiClient.getClient().create(RetrofitArrayAPI.class);

        Call<List<User>> call = service.getUserDetails();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response, Retrofit retrofit) {

                try {

                    List<User> Data = response.body();

                    mAdapter = new RecyclerViewAdapter(Data);
                    RecyclerView.setAdapter(mAdapter);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

}
