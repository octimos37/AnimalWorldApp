package com.example.myapplication.LepidopteraFamilies.Papilionidae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.LepidopteraFamilies.Papilionidae.Papilionidae;
import com.example.myapplication.LepidopteraFamilies.Papilionidae.PapilionidaeAdapter;
import com.example.myapplication.LepidopteraFamilies.Papilionidae.PapilionidaeRecyclerViewInterface;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PapilionidaeAdapter extends RecyclerView.Adapter<PapilionidaeAdapter.ViewHolder>{
    private Context context;
    private List<Papilionidae> data;
    private List<Papilionidae> filteredList;
    private PapilionidaeAdapter adapter;
    private final PapilionidaeRecyclerViewInterface PapilionidaeRecyclerViewInterface;


    public PapilionidaeAdapter(List<Papilionidae> data, PapilionidaeRecyclerViewInterface PapilionidaeRecyclerViewInterface) {
        this.data = data;
        this.PapilionidaeRecyclerViewInterface = PapilionidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Papilionidae> listPapilionidae){
        this.data = listPapilionidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PapilionidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new PapilionidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PapilionidaeAdapter.ViewHolder holder, int position) {
        Papilionidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PapilionidaeRecyclerViewInterface.onItemClick(item);
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
