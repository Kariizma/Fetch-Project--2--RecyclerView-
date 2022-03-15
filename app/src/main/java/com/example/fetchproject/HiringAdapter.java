package com.example.fetchproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HiringAdapter extends RecyclerView.Adapter<HiringAdapter.ViewHolder> {

    private List<Hiring> hiringList;

    public HiringAdapter(List<Hiring> hiringList) {
        this.hiringList = hiringList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hiring_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.tvId.setText("id: " + String.valueOf(hiringList.get(position).getId()));
        holder.tvListId.setText("listId: " + String.valueOf(hiringList.get(position).getListId()));
        holder.tvName.setText("name: " + hiringList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return hiringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvId;
        TextView tvListId;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.id);
            tvListId = itemView.findViewById(R.id.listId);
            tvName = itemView.findViewById(R.id.name);

        }
    }
}
