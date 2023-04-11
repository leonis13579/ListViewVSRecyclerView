package com.example.listviewvsrecyclerview.data.repositories;

import android.app.Application;
import android.view.animation.Transformation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.listviewvsrecyclerview.data.data_sources.ItemsDataSource;
import com.example.listviewvsrecyclerview.data.data_sources.room.entites.ItemEntity;
import com.example.listviewvsrecyclerview.data.data_sources.room.root.AppDatabase;
import com.example.listviewvsrecyclerview.data.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemsRepository {
    private ItemsDataSource mDataSource;
    private AppDatabase databaseSource;

    public ItemsRepository(Application application) {
        this.mDataSource = new ItemsDataSource();
        this.databaseSource = AppDatabase.getDatabase(application);

    }

    public LiveData<List<Item>> getData() {
        return mDataSource.items();
    }
    public LiveData<List<Item>> getDatabaseData() {
        return Transformations.map(
                databaseSource.itemDAO().getAllItems(),
                (values) -> values.stream().map(ItemEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addItem(Item newItem) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.itemDAO().addNewItem(new ItemEntity(newItem.getValue()));
        });
    }
}
