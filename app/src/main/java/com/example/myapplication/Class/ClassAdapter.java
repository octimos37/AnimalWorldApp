package com.example.myapplication.Class;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.CarnivoraFamilies.Canidae.Canidae;
import com.example.myapplication.Mammals.Mammals;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder>{
    private List<Class> data;
    private OnItemClickListener onItemClickListener;


    public ClassAdapter(List<Class> data, OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Class> listClass){
        this.data = listClass;
    }

    @NonNull
    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Class item = data.get(position);
                String itemId = item.getId();
                String des = item.getDescriptionClass();
                onItemClickListener.onItemClick(Integer.parseInt(itemId), des);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.ViewHolder holder, int position) {
        Class item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView_class);
        holder.textViewE.setText(item.getNameE());
        holder.textViewTV.setText(item.getNameTV());
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


    public void setOnItemClickListener(OnItemClickListener listener) {
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
