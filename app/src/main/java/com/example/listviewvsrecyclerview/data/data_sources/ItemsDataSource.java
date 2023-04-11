package com.example.listviewvsrecyclerview.data.data_sources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.listviewvsrecyclerview.data.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsDataSource {
    public LiveData<List<Item>> items() {
        MutableLiveData<List<Item>> result = new MutableLiveData<>();

        new Thread(() -> {
            ArrayList<Item> resultArr = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                resultArr.add(new Item("Item #" + (i + 1)));
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            result.postValue(resultArr);
        }).start();


        return result;
    }
}
