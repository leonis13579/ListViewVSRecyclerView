package com.example.listviewvsrecyclerview.data.data_sources;

import com.example.listviewvsrecyclerview.data.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsDataSource {
    public List<Item> items() {
        ArrayList<Item> result = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            result.add(new Item("Item #" + (i + 1)));
        }

        return result;
    }
}
