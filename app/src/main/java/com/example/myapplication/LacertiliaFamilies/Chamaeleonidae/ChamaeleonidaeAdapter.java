package com.example.myapplication.LacertiliaFamilies.Chamaeleonidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.LacertiliaFamilies.Chamaeleonidae.Chamaeleonidae;
import com.example.myapplication.LacertiliaFamilies.Chamaeleonidae.ChamaeleonidaeAdapter;
import com.example.myapplication.LacertiliaFamilies.Chamaeleonidae.ChamaeleonidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChamaeleonidaeAdapter extends RecyclerView.Adapter<ChamaeleonidaeAdapter.ViewHolder>{
    private Context context;
    private List<Chamaeleonidae> data;
    private List<Chamaeleonidae> filteredList;
    private ChamaeleonidaeAdapter adapter;
    private final com.example.myapplication.LacertiliaFamilies.Chamaeleonidae.ChamaeleonidaeRecyclerViewInterface ChamaeleonidaeRecyclerViewInterface;


    public ChamaeleonidaeAdapter(List<Chamaeleonidae> data, ChamaeleonidaeRecyclerViewInterface ChamaeleonidaeRecyclerViewInterface) {
        this.data = data;
        this.ChamaeleonidaeRecyclerViewInterface = ChamaeleonidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Chamaeleonidae> listChamaeleonidae){
        this.data = listChamaeleonidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChamaeleonidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ChamaeleonidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamaeleonidaeAdapter.ViewHolder holder, int position) {
        Chamaeleonidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChamaeleonidaeRecyclerViewInterface.onItemClick(item);
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
