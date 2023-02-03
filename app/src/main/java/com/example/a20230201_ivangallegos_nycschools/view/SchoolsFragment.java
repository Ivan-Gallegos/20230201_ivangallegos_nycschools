package com.example.a20230201_ivangallegos_nycschools.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.a20230201_ivangallegos_nycschools.databinding.FragmentSchoolsBinding;
import com.example.a20230201_ivangallegos_nycschools.viewmodel.SchoolsViewModel;

public class SchoolsFragment extends Fragment {

    private FragmentSchoolsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSchoolsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rvSchools.setLayoutManager(new LinearLayoutManager(getContext()));
        SchoolsAdapter schoolsAdapter = new SchoolsAdapter();
        binding.rvSchools.setAdapter(schoolsAdapter);

        SchoolsViewModel vm = new ViewModelProvider(this).get(SchoolsViewModel.class);
        vm.getSchools().observe(getViewLifecycleOwner(), schoolsAdapter::setSchools);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}