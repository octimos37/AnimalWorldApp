package com.example.myapplication.GymnophionaFamilies.Ichthyophiidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.GymnophionaFamilies.Ichthyophiidae.Ichthyophiidae;
import com.example.myapplication.GymnophionaFamilies.Ichthyophiidae.IchthyophiidaeAdapter;
import com.example.myapplication.GymnophionaFamilies.Ichthyophiidae.IchthyophiidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class IchthyophiidaeAdapter extends RecyclerView.Adapter<IchthyophiidaeAdapter.ViewHolder>{
    private Context context;
    private List<Ichthyophiidae> data;
    private List<Ichthyophiidae> filteredList;
    private IchthyophiidaeAdapter adapter;
    private final com.example.myapplication.GymnophionaFamilies.Ichthyophiidae.IchthyophiidaeRecyclerViewInterface IchthyophiidaeRecyclerViewInterface;


    public IchthyophiidaeAdapter(List<Ichthyophiidae> data, IchthyophiidaeRecyclerViewInterface IchthyophiidaeRecyclerViewInterface) {
        this.data = data;
        this.IchthyophiidaeRecyclerViewInterface = IchthyophiidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Ichthyophiidae> listIchthyophiidae){
        this.data = listIchthyophiidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IchthyophiidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new IchthyophiidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IchthyophiidaeAdapter.ViewHolder holder, int position) {
        Ichthyophiidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IchthyophiidaeRecyclerViewInterface.onItemClick(item);
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
