package com.example.a20230201_ivangallegos_nycschools.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a20230201_ivangallegos_nycschools.model.pojo.School
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

// Using Kotlin object keyword to easily make a Singleton with no parameters
object Repo {
    const val TAG = "Repo"
    // Instantiate Retrofit with GsonConverter to deserialize JSON response
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(SchoolsService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    // Instantiate SchoolsService using Retrofit
    private val schoolsService = retrofit.create<SchoolsService>()
    // Enqueue Call and post response to LiveData if successful
    // Else log throwable
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
    // Enqueue Call and post response to LiveData if successful
    // Else log throwable
    fun getScores(dbn: String): LiveData<List<Score>> = MutableLiveData<List<Score>>().apply {
        schoolsService.getScores(dbn).enqueue(object : Callback<List<Score>?> {
            override fun onResponse(call: Call<List<Score>?>, response: Response<List<Score>?>) {
                val scores = response.body()
                postValue(scores)
            }

            override fun onFailure(call: Call<List<Score>?>, t: Throwable) {
                Log.e(TAG, t.message, t)
            }
        })
    }
}