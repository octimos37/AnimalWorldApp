package com.example.myapplication.GalliformesFamilies.Phasianidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.GalliformesFamilies.Phasianidae.Phasianidae;
import com.example.myapplication.GalliformesFamilies.Phasianidae.PhasianidaeAdapter;
import com.example.myapplication.GalliformesFamilies.Phasianidae.PhasianidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhasianidaeAdapter extends RecyclerView.Adapter<PhasianidaeAdapter.ViewHolder>{
    private Context context;
    private List<Phasianidae> data;
    private List<Phasianidae> filteredList;
    private PhasianidaeAdapter adapter;
    private final com.example.myapplication.GalliformesFamilies.Phasianidae.PhasianidaeRecyclerViewInterface PhasianidaeRecyclerViewInterface;


    public PhasianidaeAdapter(List<Phasianidae> data, PhasianidaeRecyclerViewInterface PhasianidaeRecyclerViewInterface) {
        this.data = data;
        this.PhasianidaeRecyclerViewInterface = PhasianidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Phasianidae> listPhasianidae){
        this.data = listPhasianidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhasianidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new PhasianidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhasianidaeAdapter.ViewHolder holder, int position) {
        Phasianidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhasianidaeRecyclerViewInterface.onItemClick(item);
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
