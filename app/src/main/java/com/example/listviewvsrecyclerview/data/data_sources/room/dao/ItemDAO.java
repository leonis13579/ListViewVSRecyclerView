package com.example.listviewvsrecyclerview.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.listviewvsrecyclerview.data.data_sources.room.entites.ItemEntity;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("SELECT * FROM ItemEntity")
    LiveData<List<ItemEntity>> getAllItems();

    @Insert
    void addNewItem(ItemEntity newItem);
}
