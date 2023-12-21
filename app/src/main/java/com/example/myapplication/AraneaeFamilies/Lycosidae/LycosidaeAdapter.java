package com.example.myapplication.AraneaeFamilies.Lycosidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AraneaeFamilies.Lycosidae.Lycosidae;
import com.example.myapplication.AraneaeFamilies.Lycosidae.LycosidaeAdapter;
import com.example.myapplication.AraneaeFamilies.Lycosidae.LycosidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LycosidaeAdapter extends RecyclerView.Adapter<LycosidaeAdapter.ViewHolder>{
    private Context context;
    private List<Lycosidae> data;
    private List<Lycosidae> filteredList;
    private LycosidaeAdapter adapter;
    private final com.example.myapplication.AraneaeFamilies.Lycosidae.LycosidaeRecyclerViewInterface LycosidaeRecyclerViewInterface;


    public LycosidaeAdapter(List<Lycosidae> data, LycosidaeRecyclerViewInterface LycosidaeRecyclerViewInterface) {
        this.data = data;
        this.LycosidaeRecyclerViewInterface = LycosidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Lycosidae> listLycosidae){
        this.data = listLycosidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LycosidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new LycosidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LycosidaeAdapter.ViewHolder holder, int position) {
        Lycosidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LycosidaeRecyclerViewInterface.onItemClick(item);
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
