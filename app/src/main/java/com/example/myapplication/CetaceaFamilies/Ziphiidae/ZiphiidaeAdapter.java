package com.example.myapplication.CetaceaFamilies.Ziphiidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CetaceaFamilies.Ziphiidae.Ziphiidae;
import com.example.myapplication.CetaceaFamilies.Ziphiidae.ZiphiidaeAdapter;
import com.example.myapplication.CetaceaFamilies.Ziphiidae.ZiphiidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ZiphiidaeAdapter extends RecyclerView.Adapter<ZiphiidaeAdapter.ViewHolder>{
    private Context context;
    private List<Ziphiidae> data;
    private List<Ziphiidae> filteredList;
    private ZiphiidaeAdapter adapter;
    private final com.example.myapplication.CetaceaFamilies.Ziphiidae.ZiphiidaeRecyclerViewInterface ZiphiidaeRecyclerViewInterface;


    public ZiphiidaeAdapter(List<Ziphiidae> data, ZiphiidaeRecyclerViewInterface ZiphiidaeRecyclerViewInterface) {
        this.data = data;
        this.ZiphiidaeRecyclerViewInterface = ZiphiidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Ziphiidae> listZiphiidae){
        this.data = listZiphiidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ZiphiidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ZiphiidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZiphiidaeAdapter.ViewHolder holder, int position) {
        Ziphiidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZiphiidaeRecyclerViewInterface.onItemClick(item);
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
