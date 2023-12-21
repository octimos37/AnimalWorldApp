package com.example.myapplication.CetaceaFamilies.Balaenopteridae;

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

public class BalaenopteridaeAdapter extends RecyclerView.Adapter<BalaenopteridaeAdapter.ViewHolder>{
    private Context context;
    private List<Balaenopteridae> data;
    private List<Balaenopteridae> filteredList;
    private BalaenopteridaeAdapter adapter;
    private final BalaenopteridaeRecyclerViewInterface BalaenopteridaeRecyclerViewInterface;


    public BalaenopteridaeAdapter(List<Balaenopteridae> data, BalaenopteridaeRecyclerViewInterface BalaenopteridaeRecyclerViewInterface) {
        this.data = data;
        this.BalaenopteridaeRecyclerViewInterface = BalaenopteridaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Balaenopteridae> listBalaenopteridae){
        this.data = listBalaenopteridae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BalaenopteridaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new BalaenopteridaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BalaenopteridaeAdapter.ViewHolder holder, int position) {
        Balaenopteridae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BalaenopteridaeRecyclerViewInterface.onItemClick(item);
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
