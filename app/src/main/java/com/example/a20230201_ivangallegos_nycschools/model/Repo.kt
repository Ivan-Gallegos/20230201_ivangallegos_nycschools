package com.example.a20230201_ivangallegos_nycschools.model

import com.example.a20230201_ivangallegos_nycschools.model.pojo.School
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repo {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(SchoolsService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val schoolsService = retrofit.create<SchoolsService>()

    fun getSchools(): Call<List<School>> = schoolsService.schools

    fun getScores(dbn: String): Call<List<Score>> = schoolsService.getScores(dbn)
}