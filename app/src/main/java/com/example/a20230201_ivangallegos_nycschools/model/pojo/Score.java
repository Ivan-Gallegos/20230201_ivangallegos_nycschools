package com.example.a20230201_ivangallegos_nycschools.model.pojo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Score{

	@SerializedName("dbn")
	private String dbn;

	@SerializedName("sat_writing_avg_score")
	private String satWritingAvgScore;

	@SerializedName("sat_critical_reading_avg_score")
	private String satCriticalReadingAvgScore;

	@SerializedName("sat_math_avg_score")
	private String satMathAvgScore;

	@SerializedName("school_name")
	private String schoolName;

	@SerializedName("num_of_sat_test_takers")
	private String numOfSatTestTakers;

	public String getDbn(){
		return dbn;
	}

	public String getSatWritingAvgScore(){
		return satWritingAvgScore;
	}

	public String getSatCriticalReadingAvgScore(){
		return satCriticalReadingAvgScore;
	}

	public String getSatMathAvgScore(){
		return satMathAvgScore;
	}

	public String getSchoolName(){
		return schoolName;
	}

	public String getNumOfSatTestTakers(){
		return numOfSatTestTakers;
	}

	@NonNull
	@Override
	public String toString() {
		return "Score{" +
				"dbn='" + dbn + '\'' +
				", satWritingAvgScore='" + satWritingAvgScore + '\'' +
				", satCriticalReadingAvgScore='" + satCriticalReadingAvgScore + '\'' +
				", satMathAvgScore='" + satMathAvgScore + '\'' +
				", schoolName='" + schoolName + '\'' +
				", numOfSatTestTakers='" + numOfSatTestTakers + '\'' +
				'}';
	}
}