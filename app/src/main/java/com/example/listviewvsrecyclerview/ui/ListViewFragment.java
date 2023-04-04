package com.example.listviewvsrecyclerview.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.listviewvsrecyclerview.R;
import com.example.listviewvsrecyclerview.data.models.Item;
import com.example.listviewvsrecyclerview.data.repositories.ItemsRepository;
import com.example.listviewvsrecyclerview.databinding.ListViewFragmentBinding;
import com.example.listviewvsrecyclerview.ui.adapters.ListViewAdapter;

import java.util.List;

public class ListViewFragment extends Fragment {
    ListViewFragmentBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ListViewFragmentBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ItemsRepository repo = new ItemsRepository();

        mBinding.listView.setAdapter(
                new ListViewAdapter(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        repo.getData().toArray(new Item[0])
                )
        );
    }
}
