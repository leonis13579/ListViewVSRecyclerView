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
    }
}