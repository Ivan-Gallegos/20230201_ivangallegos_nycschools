package com.example.a20230201_ivangallegos_nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20230201_ivangallegos_nycschools.model.Repo;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score;

import java.util.List;

public class ScoresViewModel extends ViewModel {

    public LiveData<List<Score>> getScores(String dbn) {
        return Repo.INSTANCE.getScores(dbn);
    }
}