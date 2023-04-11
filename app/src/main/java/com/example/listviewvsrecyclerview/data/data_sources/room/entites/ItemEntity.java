package com.example.listviewvsrecyclerview.data.data_sources.room.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.listviewvsrecyclerview.data.models.Item;

@Entity
public class ItemEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String value;

    public ItemEntity() {
    }

    public ItemEntity(String value) {
        this.value = value;
    }

    public Item toDomainModel() {
        return new Item(value);
    }
}
