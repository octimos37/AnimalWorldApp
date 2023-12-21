package com.example.myapplication.CarnivoraFamilies.Mustelidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CarnivoraFamilies.Mustelidae.Mustelidae;
import com.example.myapplication.CarnivoraFamilies.Mustelidae.MustelidaeAdapter;
import com.example.myapplication.CarnivoraFamilies.Mustelidae.MustelidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MustelidaeAdapter extends RecyclerView.Adapter<MustelidaeAdapter.ViewHolder>{
    private Context context;
    private List<Mustelidae> data;
    private List<Mustelidae> filteredList;
    private MustelidaeAdapter adapter;
    private final com.example.myapplication.CarnivoraFamilies.Mustelidae.MustelidaeRecyclerViewInterface MustelidaeRecyclerViewInterface;


    public MustelidaeAdapter(List<Mustelidae> data, MustelidaeRecyclerViewInterface MustelidaeRecyclerViewInterface) {
        this.data = data;
        this.MustelidaeRecyclerViewInterface = MustelidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Mustelidae> listMustelidae){
        this.data = listMustelidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MustelidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new MustelidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MustelidaeAdapter.ViewHolder holder, int position) {
        Mustelidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MustelidaeRecyclerViewInterface.onItemClick(item);
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
