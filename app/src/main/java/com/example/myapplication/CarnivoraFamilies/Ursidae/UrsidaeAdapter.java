package com.example.myapplication.CarnivoraFamilies.Ursidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CarnivoraFamilies.Ursidae.Ursidae;
import com.example.myapplication.CarnivoraFamilies.Ursidae.UrsidaeAdapter;
import com.example.myapplication.CarnivoraFamilies.Ursidae.UrsidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UrsidaeAdapter extends RecyclerView.Adapter<UrsidaeAdapter.ViewHolder>{
    private Context context;
    private List<Ursidae> data;
    private List<Ursidae> filteredList;
    private UrsidaeAdapter adapter;
    private final com.example.myapplication.CarnivoraFamilies.Ursidae.UrsidaeRecyclerViewInterface UrsidaeRecyclerViewInterface;


    public UrsidaeAdapter(List<Ursidae> data, UrsidaeRecyclerViewInterface UrsidaeRecyclerViewInterface) {
        this.data = data;
        this.UrsidaeRecyclerViewInterface = UrsidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Ursidae> listUrsidae){
        this.data = listUrsidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UrsidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new UrsidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UrsidaeAdapter.ViewHolder holder, int position) {
        Ursidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrsidaeRecyclerViewInterface.onItemClick(item);
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
