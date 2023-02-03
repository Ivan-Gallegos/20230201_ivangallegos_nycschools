package com.example.a20230201_ivangallegos_nycschools.view.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a20230201_ivangallegos_nycschools.databinding.FragmentScoresBinding;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.Score;
import com.example.a20230201_ivangallegos_nycschools.viewmodel.ScoresViewModel;

public class ScoresFragment extends Fragment {

    private FragmentScoresBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScoresBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String dbn = ScoresFragmentArgs.fromBundle(getArguments()).getDbn();
            ScoresViewModel vm = new ViewModelProvider(this).get(ScoresViewModel.class);
            vm.getScores(dbn).observe(getViewLifecycleOwner(), scores -> {
                String scoreStr;
                if (scores != null && !scores.isEmpty()) {
                    Score score = scores.get(0);
                    scoreStr = score.toDisplayString();
                } else {
                    scoreStr = "Score Data Not Found";
                }
                binding.tvScores.setText(scoreStr);
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}