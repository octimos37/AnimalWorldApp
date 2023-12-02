package com.example.myapplication.CarnivoraFamilies.Canidae;

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

public class CanidaeAdapter extends RecyclerView.Adapter<CanidaeAdapter.ViewHolder> {
    private Context context;
    private List<Canidae> data;
    private List<Canidae> filteredList;
    private CanidaeAdapter adapter;
    private final CanidaeRecyclerViewInterface canidaeRecyclerViewInterface;


    public CanidaeAdapter(List<Canidae> data, CanidaeRecyclerViewInterface canidaeRecyclerViewInterface) {
        this.data = data;
        this.canidaeRecyclerViewInterface = canidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Canidae> listCanidae){
        this.data = listCanidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Canidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canidaeRecyclerViewInterface.onItemClick(item);
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
