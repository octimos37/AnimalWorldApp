package com.example.myapplication.MammalsOrders.Carnivora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarnivoraAdapter extends RecyclerView.Adapter<CarnivoraAdapter.ViewHolder>{
    private List<Carnivora> data;
    private CarnivoraAdapter.OnItemClickListener onItemClickListener;


    public CarnivoraAdapter(List<Carnivora> data, CarnivoraAdapter.OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Carnivora> listCarnivora){
        this.data = listCarnivora;
    }

    @NonNull
    @Override
    public CarnivoraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        CarnivoraAdapter.ViewHolder viewHolder = new CarnivoraAdapter.ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Carnivora item = data.get(position);
                String itemId = item.getFamilyID();
                onItemClickListener.onItemClick(Integer.parseInt(itemId));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarnivoraAdapter.ViewHolder holder, int position) {
        Carnivora item = data.get(position);

        Picasso.get().load(item.getImagesFamyli()).into(holder.imageView_class);
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(int itemId);
    }

    public void setOnItemClickListener(CarnivoraAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_class;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView_class = itemView.findViewById(R.id.iv_class);
        }
    }
}
