package com.example.myapplication.PasseriformesFamilies.Turdidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.PasseriformesFamilies.Turdidae.Turdidae;
import com.example.myapplication.PasseriformesFamilies.Turdidae.TurdidaeAdapter;
import com.example.myapplication.PasseriformesFamilies.Turdidae.TurdidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TurdidaeAdapter extends RecyclerView.Adapter<TurdidaeAdapter.ViewHolder>{
    private Context context;
    private List<Turdidae> data;
    private List<Turdidae> filteredList;
    private TurdidaeAdapter adapter;
    private final com.example.myapplication.PasseriformesFamilies.Turdidae.TurdidaeRecyclerViewInterface TurdidaeRecyclerViewInterface;


    public TurdidaeAdapter(List<Turdidae> data, TurdidaeRecyclerViewInterface TurdidaeRecyclerViewInterface) {
        this.data = data;
        this.TurdidaeRecyclerViewInterface = TurdidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Turdidae> listTurdidae){
        this.data = listTurdidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TurdidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new TurdidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TurdidaeAdapter.ViewHolder holder, int position) {
        Turdidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TurdidaeRecyclerViewInterface.onItemClick(item);
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
