package com.example.myapplication.ChiropteraFamilies.Pteropodidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ChiropteraFamilies.Pteropodidae.Pteropodidae;
import com.example.myapplication.ChiropteraFamilies.Pteropodidae.PteropodidaeAdapter;
import com.example.myapplication.ChiropteraFamilies.Pteropodidae.PteropodidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PteropodidaeAdapter extends RecyclerView.Adapter<PteropodidaeAdapter.ViewHolder>{
    private Context context;
    private List<Pteropodidae> data;
    private List<Pteropodidae> filteredList;
    private PteropodidaeAdapter adapter;
    private final com.example.myapplication.ChiropteraFamilies.Pteropodidae.PteropodidaeRecyclerViewInterface PteropodidaeRecyclerViewInterface;


    public PteropodidaeAdapter(List<Pteropodidae> data, PteropodidaeRecyclerViewInterface PteropodidaeRecyclerViewInterface) {
        this.data = data;
        this.PteropodidaeRecyclerViewInterface = PteropodidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Pteropodidae> listPteropodidae){
        this.data = listPteropodidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PteropodidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new PteropodidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PteropodidaeAdapter.ViewHolder holder, int position) {
        Pteropodidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PteropodidaeRecyclerViewInterface.onItemClick(item);
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
