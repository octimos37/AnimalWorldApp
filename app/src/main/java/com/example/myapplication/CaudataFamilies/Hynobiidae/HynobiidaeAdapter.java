package com.example.myapplication.CaudataFamilies.Hynobiidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CaudataFamilies.Hynobiidae.Hynobiidae;
import com.example.myapplication.CaudataFamilies.Hynobiidae.HynobiidaeAdapter;
import com.example.myapplication.CaudataFamilies.Hynobiidae.HynobiidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HynobiidaeAdapter extends RecyclerView.Adapter<HynobiidaeAdapter.ViewHolder>{
    private Context context;
    private List<Hynobiidae> data;
    private List<Hynobiidae> filteredList;
    private HynobiidaeAdapter adapter;
    private final com.example.myapplication.CaudataFamilies.Hynobiidae.HynobiidaeRecyclerViewInterface HynobiidaeRecyclerViewInterface;


    public HynobiidaeAdapter(List<Hynobiidae> data, HynobiidaeRecyclerViewInterface HynobiidaeRecyclerViewInterface) {
        this.data = data;
        this.HynobiidaeRecyclerViewInterface = HynobiidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Hynobiidae> listHynobiidae){
        this.data = listHynobiidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HynobiidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new HynobiidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HynobiidaeAdapter.ViewHolder holder, int position) {
        Hynobiidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HynobiidaeRecyclerViewInterface.onItemClick(item);
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
