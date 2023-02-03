package com.example.a20230201_ivangallegos_nycschools.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a20230201_ivangallegos_nycschools.model.pojo.School
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object Repo {
    const val TAG = "Repo"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(SchoolsService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val schoolsService = retrofit.create<SchoolsService>()

    fun getSchools(): LiveData<List<School>> = MutableLiveData<List<School>>().apply {
        schoolsService.schools.enqueue(object : Callback<List<School>?> {
            override fun onResponse(call: Call<List<School>?>, response: Response<List<School>?>) {
                val schools = response.body()
                postValue(schools)
            }

            override fun onFailure(call: Call<List<School>?>, t: Throwable) {
                Log.e(TAG, t.message, t)
            }
        })
    }

    fun getScores(dbn: String): Call<List<Score>> = schoolsService.getScores(dbn)
}