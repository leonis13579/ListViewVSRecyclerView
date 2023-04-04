package com.example.listviewvsrecyclerview.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviewvsrecyclerview.data.models.Item;
import com.example.listviewvsrecyclerview.databinding.ItemViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewItemViewHolder> {
    List<Item> data;

    public RecyclerViewAdapter() {
        this.data = new ArrayList<>();
    }

    public void updateData(List<Item> newData) {
        data = newData;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding mBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new RecyclerViewItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewItemViewHolder holder, int position) {
        holder.binding.itemTextId.setText(data.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RecyclerViewItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewBinding binding;

        public RecyclerViewItemViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemViewBinding.bind(itemView);
        }
    }
}
