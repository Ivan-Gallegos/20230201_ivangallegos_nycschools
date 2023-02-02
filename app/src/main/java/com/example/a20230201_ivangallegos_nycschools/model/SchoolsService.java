package com.example.a20230201_ivangallegos_nycschools.model;

import com.example.a20230201_ivangallegos_nycschools.model.pojo.School;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolsService {
    String BASE_URL = "https://data.cityofnewyork.us/resource/";

    @GET("s3k6-pzi2.json")
    Call<List<School>> getSchools();

    @GET("f9bf-2cp4.json")
    Call<List<Score>> getScores(@Query("dbn") String dbn);
}