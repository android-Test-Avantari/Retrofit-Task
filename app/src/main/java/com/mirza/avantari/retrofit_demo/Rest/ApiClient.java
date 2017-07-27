package com.mirza.avantari.retrofit_demo.Rest;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by AHMED on 27-07-2017.
 */

public class ApiClient {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
