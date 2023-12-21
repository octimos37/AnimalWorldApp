package com.example.myapplication.StrigiformesFamilies.Strigidae;

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

public class StrigidaeAdapter extends RecyclerView.Adapter<StrigidaeAdapter.ViewHolder>{
    private Context context;
    private List<Strigidae> data;
    private List<Strigidae> filteredList;
    private StrigidaeAdapter adapter;
    private final StrigidaeRecyclerViewInterface StrigidaeRecyclerViewInterface;


    public StrigidaeAdapter(List<Strigidae> data, StrigidaeRecyclerViewInterface StrigidaeRecyclerViewInterface) {
        this.data = data;
        this.StrigidaeRecyclerViewInterface = StrigidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Strigidae> listStrigidae){
        this.data = listStrigidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StrigidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new StrigidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StrigidaeAdapter.ViewHolder holder, int position) {
        Strigidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrigidaeRecyclerViewInterface.onItemClick(item);
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
