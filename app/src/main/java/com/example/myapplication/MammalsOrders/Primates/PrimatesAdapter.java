package com.example.myapplication.MammalsOrders.Primates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MammalsOrders.Monotremata.Monotremata;
import com.example.myapplication.MammalsOrders.Monotremata.MonotremataAdapter;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PrimatesAdapter extends RecyclerView.Adapter<PrimatesAdapter.ViewHolder>{
    private List<Primates> data;
    private PrimatesAdapter.OnItemClickListener onItemClickListener;


    public PrimatesAdapter(List<Primates> data, PrimatesAdapter.OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Primates> listCarnivora){
        this.data = listCarnivora;
    }

    @NonNull
    @Override
    public PrimatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        PrimatesAdapter.ViewHolder viewHolder = new PrimatesAdapter.ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Primates item = data.get(position);
                String itemId = item.getFamilyID();
                String des = item.getDescriptionFamily();
                onItemClickListener.onItemClick(Integer.parseInt(itemId), des);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PrimatesAdapter.ViewHolder holder, int position) {
        Primates item = data.get(position);

        Picasso.get().load(item.getImagesFamyli()).into(holder.imageView_class);
        holder.textViewE.setText(item.getFamilyNameE());
        holder.textViewTV.setText(item.getFamilyNameTV());
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(int itemId, String des);
    }

    public void setOnItemClickListener(PrimatesAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_class;
        private TextView textViewE;
        private TextView textViewTV;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView_class = itemView.findViewById(R.id.iv_class);
            textViewE = itemView.findViewById(R.id.iv_E);
            textViewTV = itemView.findViewById(R.id.iv_TV);
        }
    }
}
