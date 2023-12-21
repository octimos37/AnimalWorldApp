package com.example.myapplication.PelecaniformesFamilies.Phaethontidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.PelecaniformesFamilies.Phaethontidae.Phaethontidae;
import com.example.myapplication.PelecaniformesFamilies.Phaethontidae.PhaethontidaeAdapter;
import com.example.myapplication.PelecaniformesFamilies.Phaethontidae.PhaethontidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhaethontidaeAdapter extends RecyclerView.Adapter<PhaethontidaeAdapter.ViewHolder>{
    private Context context;
    private List<Phaethontidae> data;
    private List<Phaethontidae> filteredList;
    private PhaethontidaeAdapter adapter;
    private final com.example.myapplication.PelecaniformesFamilies.Phaethontidae.PhaethontidaeRecyclerViewInterface PhaethontidaeRecyclerViewInterface;


    public PhaethontidaeAdapter(List<Phaethontidae> data, PhaethontidaeRecyclerViewInterface PhaethontidaeRecyclerViewInterface) {
        this.data = data;
        this.PhaethontidaeRecyclerViewInterface = PhaethontidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Phaethontidae> listPhaethontidae){
        this.data = listPhaethontidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhaethontidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new PhaethontidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhaethontidaeAdapter.ViewHolder holder, int position) {
        Phaethontidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhaethontidaeRecyclerViewInterface.onItemClick(item);
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
