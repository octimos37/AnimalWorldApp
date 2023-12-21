package com.example.myapplication.CypriniformesFamilies.Clariidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CypriniformesFamilies.Clariidae.Clariidae;
import com.example.myapplication.CypriniformesFamilies.Clariidae.ClariidaeAdapter;
import com.example.myapplication.CypriniformesFamilies.Clariidae.ClariidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ClariidaeAdapter extends RecyclerView.Adapter<ClariidaeAdapter.ViewHolder>{
    private Context context;
    private List<Clariidae> data;
    private List<Clariidae> filteredList;
    private ClariidaeAdapter adapter;
    private final com.example.myapplication.CypriniformesFamilies.Clariidae.ClariidaeRecyclerViewInterface ClariidaeRecyclerViewInterface;


    public ClariidaeAdapter(List<Clariidae> data, ClariidaeRecyclerViewInterface ClariidaeRecyclerViewInterface) {
        this.data = data;
        this.ClariidaeRecyclerViewInterface = ClariidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Clariidae> listClariidae){
        this.data = listClariidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClariidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ClariidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClariidaeAdapter.ViewHolder holder, int position) {
        Clariidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClariidaeRecyclerViewInterface.onItemClick(item);
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
