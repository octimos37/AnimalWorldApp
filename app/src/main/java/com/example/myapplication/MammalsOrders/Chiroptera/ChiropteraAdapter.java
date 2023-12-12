package com.example.myapplication.MammalsOrders.Chiroptera;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MammalsOrders.Carnivora.Carnivora;
import com.example.myapplication.MammalsOrders.Carnivora.CarnivoraAdapter;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChiropteraAdapter extends RecyclerView.Adapter<ChiropteraAdapter.ViewHolder>{
    private List<Chiroptera> data;
    private ChiropteraAdapter.OnItemClickListener onItemClickListener;


    public ChiropteraAdapter(List<Chiroptera> data, ChiropteraAdapter.OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Chiroptera> listCarnivora){
        this.data = listCarnivora;
    }

    @NonNull
    @Override
    public ChiropteraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        ChiropteraAdapter.ViewHolder viewHolder = new ChiropteraAdapter.ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Chiroptera item = data.get(position);
                String itemId = item.getFamilyID();
                String des = item.getDescriptionFamily();
                onItemClickListener.onItemClick(Integer.parseInt(itemId), des);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChiropteraAdapter.ViewHolder holder, int position) {
        Chiroptera item = data.get(position);

        Picasso.get().load(item.getImagesFamyli()).into(holder.imageView_class);
        holder.textViewE.setText(item.getFamilyNameE());
        holder.textViewTV.setText(item.getFamilyNameTV());
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(int itemId, String des);
    }

    public void setOnItemClickListener(ChiropteraAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_class;
        private TextView textViewE;
        private TextView textViewTV;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView_class = itemView.findViewById(R.id.iv_class);
            textViewE = itemView.findViewById(R.id.iv_E);
            textViewTV = itemView.findViewById(R.id.iv_TV);
        }
    }
}
