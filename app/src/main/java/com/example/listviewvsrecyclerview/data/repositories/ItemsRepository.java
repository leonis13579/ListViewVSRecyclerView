package com.example.listviewvsrecyclerview.data.repositories;

import com.example.listviewvsrecyclerview.data.data_sources.ItemsDataSource;
import com.example.listviewvsrecyclerview.data.models.Item;

import java.util.List;

public class ItemsRepository {
    private ItemsDataSource mDataSource;

    public ItemsRepository() {
        this.mDataSource = new ItemsDataSource();
    }

    public List<Item> getData() {
        return mDataSource.items();
    }
}
