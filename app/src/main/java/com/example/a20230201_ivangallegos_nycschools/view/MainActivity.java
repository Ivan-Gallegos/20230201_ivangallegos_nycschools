package com.example.a20230201_ivangallegos_nycschools.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a20230201_ivangallegos_nycschools.R;
import com.example.a20230201_ivangallegos_nycschools.model.Repo;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.School;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new Thread(
//                () -> Repo.INSTANCE.getSchools().enqueue(schoolsCallback())
//        ).start();
    }

    @NonNull
    private Callback<List<School>> schoolsCallback() {
        return new Callback<List<School>>() {
            @Override
            public void onResponse(@NonNull Call<List<School>> call, @NonNull Response<List<School>> response) {
                List<School> schools = response.body();
                if (schools != null) {
                    for (int i = 0; i < schools.size(); i++) {
                        School school = schools.get(i);
                        Log.d(TAG, school.toString());

                        Repo.INSTANCE.getScores(school.getDbn()).enqueue(scoresCallback());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<School>> call, @NonNull Throwable t) {
                Log.e(TAG, t.getLocalizedMessage(), t);
            }
        };
    }

    @NonNull
    private Callback<List<Score>> scoresCallback() {
        return new Callback<List<Score>>() {
            @Override
            public void onResponse(@NonNull Call<List<Score>> call, @NonNull Response<List<Score>> response) {
                List<Score> scores = response.body();
                if (scores != null && !scores.isEmpty()) {
                    Score score = scores.get(0);
                    Log.d(TAG, score.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Score>> call, @NonNull Throwable t) {
                Log.e(TAG, t.getLocalizedMessage(), t);
            }
        };
    }
}