package com.example.myapplication.PsittaciformesFamilies.Psittacidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.PsittaciformesFamilies.Psittacidae.Psittacidae;
import com.example.myapplication.PsittaciformesFamilies.Psittacidae.PsittacidaeAdapter;
import com.example.myapplication.PsittaciformesFamilies.Psittacidae.PsittacidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PsittacidaeAdapter extends RecyclerView.Adapter<PsittacidaeAdapter.ViewHolder>{
    private Context context;
    private List<Psittacidae> data;
    private List<Psittacidae> filteredList;
    private PsittacidaeAdapter adapter;
    private final com.example.myapplication.PsittaciformesFamilies.Psittacidae.PsittacidaeRecyclerViewInterface PsittacidaeRecyclerViewInterface;


    public PsittacidaeAdapter(List<Psittacidae> data, PsittacidaeRecyclerViewInterface PsittacidaeRecyclerViewInterface) {
        this.data = data;
        this.PsittacidaeRecyclerViewInterface = PsittacidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Psittacidae> listPsittacidae){
        this.data = listPsittacidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PsittacidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new PsittacidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PsittacidaeAdapter.ViewHolder holder, int position) {
        Psittacidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PsittacidaeRecyclerViewInterface.onItemClick(item);
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
