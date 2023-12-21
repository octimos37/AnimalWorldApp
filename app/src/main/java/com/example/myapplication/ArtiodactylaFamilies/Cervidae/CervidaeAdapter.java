package com.example.myapplication.ArtiodactylaFamilies.Cervidae;

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

public class CervidaeAdapter extends RecyclerView.Adapter<CervidaeAdapter.ViewHolder>{
    private Context context;
    private List<Cervidae> data;
    private List<Cervidae> filteredList;
    private CervidaeAdapter adapter;
    private final CervidaeRecyclerViewInterface CervidaeRecyclerViewInterface;


    public CervidaeAdapter(List<Cervidae> data, CervidaeRecyclerViewInterface CervidaeRecyclerViewInterface) {
        this.data = data;
        this.CervidaeRecyclerViewInterface = CervidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Cervidae> listCervidae){
        this.data = listCervidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CervidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CervidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CervidaeAdapter.ViewHolder holder, int position) {
        Cervidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CervidaeRecyclerViewInterface.onItemClick(item);
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
