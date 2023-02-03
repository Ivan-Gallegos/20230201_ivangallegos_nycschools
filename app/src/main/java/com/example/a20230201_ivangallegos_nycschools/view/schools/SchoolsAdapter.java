package com.example.a20230201_ivangallegos_nycschools.view.schools;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20230201_ivangallegos_nycschools.databinding.ViewHolderSchoolBinding;
import com.example.a20230201_ivangallegos_nycschools.model.pojo.School;

import java.util.ArrayList;
import java.util.List;

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.SchoolViewHolder> {

    private List<School> schools = new ArrayList<>();
    private final OnItemClickListener onItemClickListener;

    public SchoolsAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
        notifyItemRangeChanged(0, schools.size());
    }

    public static class SchoolViewHolder extends RecyclerView.ViewHolder {

        private final ViewHolderSchoolBinding binding;

        public SchoolViewHolder(ViewHolderSchoolBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindViewHolder(School school, OnItemClickListener onItemClickListener) {
            int position = this.getAdapterPosition();
            String s = String.format("%s. %s", position, school.getSchoolName());
            binding.tvSchool.setText(s);
            binding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(school));
        }
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewHolderSchoolBinding binding = ViewHolderSchoolBinding.inflate(inflater, viewGroup, false);
        return new SchoolViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder viewHolder, final int position) {
        School school = schools.get(position);
        viewHolder.bindViewHolder(school, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }
}