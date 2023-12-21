package com.example.myapplication.RodentiaFamilies.Caviidae;

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
import com.example.myapplication.RodentiaFamilies.Caviidae.Caviidae;
import com.example.myapplication.RodentiaFamilies.Caviidae.CaviidaeAdapter;
import com.example.myapplication.RodentiaFamilies.Caviidae.CaviidaeRecyclerViewInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CaviidaeAdapter extends RecyclerView.Adapter<CaviidaeAdapter.ViewHolder>{
    private Context context;
    private List<Caviidae> data;
    private List<Caviidae> filteredList;
    private CaviidaeAdapter adapter;
    private final CaviidaeRecyclerViewInterface CaviidaeRecyclerViewInterface;


    public CaviidaeAdapter(List<Caviidae> data, CaviidaeRecyclerViewInterface CaviidaeRecyclerViewInterface) {
        this.data = data;
        this.CaviidaeRecyclerViewInterface = CaviidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Caviidae> listCaviidae){
        this.data = listCaviidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CaviidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CaviidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaviidaeAdapter.ViewHolder holder, int position) {
        Caviidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaviidaeRecyclerViewInterface.onItemClick(item);
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
