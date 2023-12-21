package com.example.myapplication.ColeopteraFamilies.Scarabaeidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ColeopteraFamilies.Scarabaeidae.Scarabaeidae;
import com.example.myapplication.ColeopteraFamilies.Scarabaeidae.ScarabaeidaeAdapter;
import com.example.myapplication.ColeopteraFamilies.Scarabaeidae.ScarabaeidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ScarabaeidaeAdapter extends RecyclerView.Adapter<ScarabaeidaeAdapter.ViewHolder>{
    private Context context;
    private List<Scarabaeidae> data;
    private List<Scarabaeidae> filteredList;
    private ScarabaeidaeAdapter adapter;
    private final com.example.myapplication.ColeopteraFamilies.Scarabaeidae.ScarabaeidaeRecyclerViewInterface ScarabaeidaeRecyclerViewInterface;


    public ScarabaeidaeAdapter(List<Scarabaeidae> data, ScarabaeidaeRecyclerViewInterface ScarabaeidaeRecyclerViewInterface) {
        this.data = data;
        this.ScarabaeidaeRecyclerViewInterface = ScarabaeidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Scarabaeidae> listScarabaeidae){
        this.data = listScarabaeidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScarabaeidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ScarabaeidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScarabaeidaeAdapter.ViewHolder holder, int position) {
        Scarabaeidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScarabaeidaeRecyclerViewInterface.onItemClick(item);
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
