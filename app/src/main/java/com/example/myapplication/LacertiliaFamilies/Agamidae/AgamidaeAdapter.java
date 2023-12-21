package com.example.myapplication.LacertiliaFamilies.Agamidae;

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

public class AgamidaeAdapter extends RecyclerView.Adapter<AgamidaeAdapter.ViewHolder>{
    private Context context;
    private List<Agamidae> data;
    private List<Agamidae> filteredList;
    private AgamidaeAdapter adapter;
    private final AgamidaeRecyclerViewInterface AgamidaeRecyclerViewInterface;


    public AgamidaeAdapter(List<Agamidae> data, AgamidaeRecyclerViewInterface AgamidaeRecyclerViewInterface) {
        this.data = data;
        this.AgamidaeRecyclerViewInterface = AgamidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Agamidae> listAgamidae){
        this.data = listAgamidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AgamidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new AgamidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgamidaeAdapter.ViewHolder holder, int position) {
        Agamidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgamidaeRecyclerViewInterface.onItemClick(item);
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
