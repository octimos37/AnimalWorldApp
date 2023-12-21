package com.example.myapplication.CypriniformesFamilies.Carassius;

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

public class CarassiusAdapter extends RecyclerView.Adapter<CarassiusAdapter.ViewHolder>{
    private Context context;
    private List<Carassius> data;
    private List<Carassius> filteredList;
    private CarassiusAdapter adapter;
    private final CarassiusRecyclerViewInterface CarassiusRecyclerViewInterface;


    public CarassiusAdapter(List<Carassius> data, CarassiusRecyclerViewInterface CarassiusRecyclerViewInterface) {
        this.data = data;
        this.CarassiusRecyclerViewInterface = CarassiusRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Carassius> listCarassius){
        this.data = listCarassius;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarassiusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CarassiusAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarassiusAdapter.ViewHolder holder, int position) {
        Carassius item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarassiusRecyclerViewInterface.onItemClick(item);
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
