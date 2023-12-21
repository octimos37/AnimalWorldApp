package com.example.myapplication.LamniformesFamilies.Lamnidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.LamniformesFamilies.Lamnidae.Lamnidae;
import com.example.myapplication.LamniformesFamilies.Lamnidae.LamnidaeAdapter;
import com.example.myapplication.LamniformesFamilies.Lamnidae.LamnidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LamnidaeAdapter extends RecyclerView.Adapter<LamnidaeAdapter.ViewHolder>{
    private Context context;
    private List<Lamnidae> data;
    private List<Lamnidae> filteredList;
    private LamnidaeAdapter adapter;
    private final com.example.myapplication.LamniformesFamilies.Lamnidae.LamnidaeRecyclerViewInterface LamnidaeRecyclerViewInterface;


    public LamnidaeAdapter(List<Lamnidae> data, LamnidaeRecyclerViewInterface LamnidaeRecyclerViewInterface) {
        this.data = data;
        this.LamnidaeRecyclerViewInterface = LamnidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Lamnidae> listLamnidae){
        this.data = listLamnidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LamnidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new LamnidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LamnidaeAdapter.ViewHolder holder, int position) {
        Lamnidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LamnidaeRecyclerViewInterface.onItemClick(item);
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
