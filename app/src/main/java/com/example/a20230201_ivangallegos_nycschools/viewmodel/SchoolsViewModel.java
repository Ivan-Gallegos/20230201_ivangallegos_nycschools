package com.example.a20230201_ivangallegos_nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20230201_ivangallegos_nycschools.model.Repo;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.School;

import java.util.List;

public class SchoolsViewModel extends ViewModel {

    private LiveData<List<School>> schools = Repo.INSTANCE.getSchools();

    public LiveData<List<School>> getSchools() {
        return schools;
    }
}