package com.example.listviewvsrecyclerview.ui.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.listviewvsrecyclerview.data.models.Item;
import com.example.listviewvsrecyclerview.data.repositories.ItemsRepository;

import java.util.List;

public class RecyclerViewModel extends AndroidViewModel {
    private ItemsRepository repo;

    private LiveData<List<Item>> mItems;

    public RecyclerViewModel(Application application) {
        super(application);
        this.repo = new ItemsRepository(application);
        mItems = repo.getDatabaseData();
    }

    public LiveData<List<Item>> getItems() {
        return mItems;
    }

    public void addItem() {
        repo.addItem(new Item("Item #interesting id"));
    }
}
