package com.example.a20230201_ivangallegos_nycschools.model.pojo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class School {

    public School(String dbn, String schoolName) {
        this.dbn = dbn;
        this.schoolName = schoolName;
    }

    private final String dbn;

    @SerializedName("school_name")
    private final String schoolName;

    public String getDbn() {
        return dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    @NonNull
    @Override
    public String toString() {
        return "School{" +
                "dbn='" + dbn + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}