package com.example.myapplication.CarnivoraFamilies.Procyonidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CarnivoraFamilies.Procyonidae.Procyonidae;
import com.example.myapplication.CarnivoraFamilies.Procyonidae.ProcyonidaeAdapter;
import com.example.myapplication.CarnivoraFamilies.Procyonidae.ProcyonidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProcyonidaeAdapter extends RecyclerView.Adapter<ProcyonidaeAdapter.ViewHolder>{
    private Context context;
    private List<Procyonidae> data;
    private List<Procyonidae> filteredList;
    private ProcyonidaeAdapter adapter;
    private final ProcyonidaeRecyclerViewInterface ProcyonidaeRecyclerViewInterface;


    public ProcyonidaeAdapter(List<Procyonidae> data, ProcyonidaeRecyclerViewInterface ProcyonidaeRecyclerViewInterface) {
        this.data = data;
        this.ProcyonidaeRecyclerViewInterface = ProcyonidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Procyonidae> listProcyonidae){
        this.data = listProcyonidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProcyonidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ProcyonidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcyonidaeAdapter.ViewHolder holder, int position) {
        Procyonidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcyonidaeRecyclerViewInterface.onItemClick(item);
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
