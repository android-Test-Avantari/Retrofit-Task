package com.mirza.avantari.retrofit_demo.Rest;

import com.mirza.avantari.retrofit_demo.Model.User;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by AHMED on 27-07-2017.
 */

public interface RetrofitArrayAPI {

    @GET("posts")
    Call<List<User>> getUserDetails();

}