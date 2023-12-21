package com.example.myapplication.CarnivoraFamilies.Felidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CarnivoraFamilies.Felidae.Felidae;
import com.example.myapplication.CarnivoraFamilies.Felidae.FelidaeAdapter;
import com.example.myapplication.CarnivoraFamilies.Felidae.FelidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FelidaeAdapter extends RecyclerView.Adapter<FelidaeAdapter.ViewHolder>{
    private Context context;
    private List<Felidae> data;
    private List<Felidae> filteredList;
    private FelidaeAdapter adapter;
    private final FelidaeRecyclerViewInterface FelidaeRecyclerViewInterface;


    public FelidaeAdapter(List<Felidae> data, FelidaeRecyclerViewInterface FelidaeRecyclerViewInterface) {
        this.data = data;
        this.FelidaeRecyclerViewInterface = FelidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Felidae> listFelidae){
        this.data = listFelidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FelidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new FelidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FelidaeAdapter.ViewHolder holder, int position) {
        Felidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FelidaeRecyclerViewInterface.onItemClick(item);
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
