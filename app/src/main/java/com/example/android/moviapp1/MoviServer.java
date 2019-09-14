package com.example.android.moviapp1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviServer {
    String apiKey = "782d50ad722ebcdc90e41160707bdede";
    String baseUrl = "http://api.themoviedb.org";

    //@Headers("content-type:application/movie")
    @GET("/3/movie/{popular}?")
    Call<MoviList> getPopularMovi(@Path("popular") String popular, @Query("api_key") String apiKey);

    @GET("/3/movie/{top_rated}?")
    Call<MoviList> getTopRatedMovi(@Path("top_rated") String top_rated, @Query("api_key") String apiKey);
}
