package com.example.myapplication.RajiformesFamilies.Rajidae;

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
import com.example.myapplication.RajiformesFamilies.Rajidae.Rajidae;
import com.example.myapplication.RajiformesFamilies.Rajidae.RajidaeAdapter;
import com.example.myapplication.RajiformesFamilies.Rajidae.RajidaeRecyclerViewInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RajidaeAdapter extends RecyclerView.Adapter<RajidaeAdapter.ViewHolder>{
    private Context context;
    private List<Rajidae> data;
    private List<Rajidae> filteredList;
    private RajidaeAdapter adapter;
    private final RajidaeRecyclerViewInterface RajidaeRecyclerViewInterface;


    public RajidaeAdapter(List<Rajidae> data, RajidaeRecyclerViewInterface RajidaeRecyclerViewInterface) {
        this.data = data;
        this.RajidaeRecyclerViewInterface = RajidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Rajidae> listRajidae){
        this.data = listRajidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RajidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new RajidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RajidaeAdapter.ViewHolder holder, int position) {
        Rajidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RajidaeRecyclerViewInterface.onItemClick(item);
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
