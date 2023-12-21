package com.example.myapplication.ArtiodactylaFamilies.Bovidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ArtiodactylaFamilies.Bovidae.Bovidae;
import com.example.myapplication.ArtiodactylaFamilies.Bovidae.BovidaeAdapter;
import com.example.myapplication.ArtiodactylaFamilies.Bovidae.BovidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BovidaeAdapter extends RecyclerView.Adapter<BovidaeAdapter.ViewHolder>{
    private Context context;
    private List<Bovidae> data;
    private List<Bovidae> filteredList;
    private BovidaeAdapter adapter;
    private final com.example.myapplication.ArtiodactylaFamilies.Bovidae.BovidaeRecyclerViewInterface BovidaeRecyclerViewInterface;


    public BovidaeAdapter(List<Bovidae> data, BovidaeRecyclerViewInterface BovidaeRecyclerViewInterface) {
        this.data = data;
        this.BovidaeRecyclerViewInterface = BovidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Bovidae> listBovidae){
        this.data = listBovidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BovidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new BovidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BovidaeAdapter.ViewHolder holder, int position) {
        Bovidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BovidaeRecyclerViewInterface.onItemClick(item);
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
