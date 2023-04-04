package com.example.listviewvsrecyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.listviewvsrecyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());

        mBinding.listViewBtn.setOnClickListener((view) -> {
            getSupportFragmentManager().beginTransaction().replace(mBinding.container.getId(), new ListViewFragment()).commit();
        });

        mBinding.recyclerViewBtn.setOnClickListener((view) -> {
            getSupportFragmentManager().beginTransaction().replace(mBinding.container.getId(), new RecyclerViewFragment()).commit();
        });
    }
}