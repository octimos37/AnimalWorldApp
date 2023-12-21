package com.example.myapplication.CaudataFamilies.Cryptobranchidae;

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

public class CryptobranchidaeAdapter extends RecyclerView.Adapter<CryptobranchidaeAdapter.ViewHolder>{
    private Context context;
    private List<Cryptobranchidae> data;
    private List<Cryptobranchidae> filteredList;
    private CryptobranchidaeAdapter adapter;
    private final CryptobranchidaeRecyclerViewInterface CryptobranchidaeRecyclerViewInterface;


    public CryptobranchidaeAdapter(List<Cryptobranchidae> data, CryptobranchidaeRecyclerViewInterface CryptobranchidaeRecyclerViewInterface) {
        this.data = data;
        this.CryptobranchidaeRecyclerViewInterface = CryptobranchidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Cryptobranchidae> listCryptobranchidae){
        this.data = listCryptobranchidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CryptobranchidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CryptobranchidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptobranchidaeAdapter.ViewHolder holder, int position) {
        Cryptobranchidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CryptobranchidaeRecyclerViewInterface.onItemClick(item);
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
