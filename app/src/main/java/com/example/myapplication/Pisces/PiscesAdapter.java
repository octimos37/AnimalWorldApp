package com.example.myapplication.Pisces;

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

public class PiscesAdapter extends RecyclerView.Adapter<PiscesAdapter.ViewHolder>{
    private List<Pisces> data;
    private PiscesAdapter.OnItemClickListener onItemClickListener;


    public PiscesAdapter(List<Pisces> data, PiscesAdapter.OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Pisces> listMammals){
        this.data = listMammals;
    }

    @NonNull
    @Override
    public PiscesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        PiscesAdapter.ViewHolder viewHolder = new PiscesAdapter.ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Pisces item = data.get(position);
                String itemId = item.getOrdoID();
                onItemClickListener.onItemClick(Integer.parseInt(itemId));
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull PiscesAdapter.ViewHolder holder, int position) {
        Pisces item = data.get(position);

        Picasso.get().load(item.getImageOrdo()).into(holder.imageView_class);
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

    public void setOnItemClickListener(PiscesAdapter.OnItemClickListener listener) {
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
