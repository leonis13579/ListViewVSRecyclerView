package com.example.listviewvsrecyclerview.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.listviewvsrecyclerview.data.models.Item;
import com.example.listviewvsrecyclerview.data.repositories.ItemsRepository;
import com.example.listviewvsrecyclerview.databinding.RecyclerViewFragmentBinding;
import com.example.listviewvsrecyclerview.ui.adapters.RecyclerViewAdapter;
import com.example.listviewvsrecyclerview.ui.view_models.RecyclerViewModel;

import java.util.List;

public class RecyclerViewFragment extends Fragment {
    RecyclerViewFragmentBinding mBinding;
    RecyclerViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = RecyclerViewFragmentBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(RecyclerViewModel.class);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(new RecyclerViewAdapter());

        mBinding.addItem.setOnClickListener((v) -> {
            mViewModel.addItem();
        });

        mViewModel.getItems().observe(getViewLifecycleOwner(), (value) -> {
            ((RecyclerViewAdapter) mBinding.recyclerView.getAdapter()).updateData(value);
        });
    }
}
