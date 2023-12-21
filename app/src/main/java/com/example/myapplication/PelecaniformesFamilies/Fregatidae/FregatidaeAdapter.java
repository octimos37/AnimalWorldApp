package com.example.myapplication.PelecaniformesFamilies.Fregatidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FregatidaeAdapter extends RecyclerView.Adapter<FregatidaeAdapter.ViewHolder>{
    private Context context;
    private List<Fregatidae> data;
    private List<Fregatidae> filteredList;
    private FregatidaeAdapter adapter;
    private final FregatidaeRecyclerViewInterface FregatidaeRecyclerViewInterface;


    public FregatidaeAdapter(List<Fregatidae> data, FregatidaeRecyclerViewInterface FregatidaeRecyclerViewInterface) {
        this.data = data;
        this.FregatidaeRecyclerViewInterface = FregatidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Fregatidae> listFregatidae){
        this.data = listFregatidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FregatidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new FregatidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FregatidaeAdapter.ViewHolder holder, int position) {
        Fregatidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FregatidaeRecyclerViewInterface.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView txt_des;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tv1);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
