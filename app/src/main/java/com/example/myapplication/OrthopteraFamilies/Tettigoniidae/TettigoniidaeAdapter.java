package com.example.myapplication.OrthopteraFamilies.Tettigoniidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.OrthopteraFamilies.Tettigoniidae.Tettigoniidae;
import com.example.myapplication.OrthopteraFamilies.Tettigoniidae.TettigoniidaeAdapter;
import com.example.myapplication.OrthopteraFamilies.Tettigoniidae.TettigoniidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TettigoniidaeAdapter extends RecyclerView.Adapter<TettigoniidaeAdapter.ViewHolder> {
    private Context context;
    private List<Tettigoniidae> data;
    private List<Tettigoniidae> filteredList;
    private TettigoniidaeAdapter adapter;
    private final com.example.myapplication.OrthopteraFamilies.Tettigoniidae.TettigoniidaeRecyclerViewInterface TettigoniidaeRecyclerViewInterface;


    public TettigoniidaeAdapter(List<Tettigoniidae> data, TettigoniidaeRecyclerViewInterface TettigoniidaeRecyclerViewInterface) {
        this.data = data;
        this.TettigoniidaeRecyclerViewInterface = TettigoniidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Tettigoniidae> listTettigoniidae){
        this.data = listTettigoniidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TettigoniidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new TettigoniidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TettigoniidaeAdapter.ViewHolder holder, int position) {
        Tettigoniidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TettigoniidaeRecyclerViewInterface.onItemClick(item);
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
