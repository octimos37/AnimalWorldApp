package com.example.myapplication.GalliformesFamilies.Cracidae;

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

public class CracidaeAdapter extends RecyclerView.Adapter<CracidaeAdapter.ViewHolder>{
    private Context context;
    private List<Cracidae> data;
    private List<Cracidae> filteredList;
    private CracidaeAdapter adapter;
    private final CracidaeRecyclerViewInterface CracidaeRecyclerViewInterface;


    public CracidaeAdapter(List<Cracidae> data, CracidaeRecyclerViewInterface CracidaeRecyclerViewInterface) {
        this.data = data;
        this.CracidaeRecyclerViewInterface = CracidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Cracidae> listCracidae){
        this.data = listCracidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CracidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CracidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CracidaeAdapter.ViewHolder holder, int position) {
        Cracidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CracidaeRecyclerViewInterface.onItemClick(item);
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
