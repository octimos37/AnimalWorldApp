package com.example.myapplication.CrocodyliaFamilies.Crocodylidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CrocodyliaFamilies.Crocodylidae.Crocodylidae;
import com.example.myapplication.CrocodyliaFamilies.Crocodylidae.CrocodylidaeAdapter;
import com.example.myapplication.CrocodyliaFamilies.Crocodylidae.CrocodylidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CrocodylidaeAdapter extends RecyclerView.Adapter<CrocodylidaeAdapter.ViewHolder>{
    private Context context;
    private List<Crocodylidae> data;
    private List<Crocodylidae> filteredList;
    private CrocodylidaeAdapter adapter;
    private final CrocodylidaeRecyclerViewInterface CrocodylidaeRecyclerViewInterface;


    public CrocodylidaeAdapter(List<Crocodylidae> data, CrocodylidaeRecyclerViewInterface CrocodylidaeRecyclerViewInterface) {
        this.data = data;
        this.CrocodylidaeRecyclerViewInterface = CrocodylidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Crocodylidae> listCrocodylidae){
        this.data = listCrocodylidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CrocodylidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CrocodylidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrocodylidaeAdapter.ViewHolder holder, int position) {
        Crocodylidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrocodylidaeRecyclerViewInterface.onItemClick(item);
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
