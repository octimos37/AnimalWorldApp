package com.example.myapplication.FalconiformesFamilies.Falconidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FalconiformesFamilies.Falconidae.Falconidae;
import com.example.myapplication.FalconiformesFamilies.Falconidae.FalconidaeAdapter;
import com.example.myapplication.FalconiformesFamilies.Falconidae.FalconidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FalconidaeAdapter extends RecyclerView.Adapter<FalconidaeAdapter.ViewHolder>{
    private Context context;
    private List<Falconidae> data;
    private List<Falconidae> filteredList;
    private FalconidaeAdapter adapter;
    private final com.example.myapplication.FalconiformesFamilies.Falconidae.FalconidaeRecyclerViewInterface FalconidaeRecyclerViewInterface;


    public FalconidaeAdapter(List<Falconidae> data, FalconidaeRecyclerViewInterface FalconidaeRecyclerViewInterface) {
        this.data = data;
        this.FalconidaeRecyclerViewInterface = FalconidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Falconidae> listFalconidae){
        this.data = listFalconidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FalconidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new FalconidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FalconidaeAdapter.ViewHolder holder, int position) {
        Falconidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FalconidaeRecyclerViewInterface.onItemClick(item);
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
