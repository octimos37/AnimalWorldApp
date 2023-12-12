package com.example.myapplication.MammalsOrders.Rodentia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MammalsOrders.Primates.Primates;
import com.example.myapplication.MammalsOrders.Primates.PrimatesAdapter;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RodentiaAdapter extends RecyclerView.Adapter<RodentiaAdapter.ViewHolder>{
    private List<Rodentia> data;
    private RodentiaAdapter.OnItemClickListener onItemClickListener;


    public RodentiaAdapter(List<Rodentia> data, RodentiaAdapter.OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Rodentia> listCarnivora){
        this.data = listCarnivora;
    }

    @NonNull
    @Override
    public RodentiaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        RodentiaAdapter.ViewHolder viewHolder = new RodentiaAdapter.ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Rodentia item = data.get(position);
                String itemId = item.getFamilyID();
                String des = item.getDescriptionFamily();
                onItemClickListener.onItemClick(Integer.parseInt(itemId), des);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RodentiaAdapter.ViewHolder holder, int position) {
        Rodentia item = data.get(position);

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

    public void setOnItemClickListener(RodentiaAdapter.OnItemClickListener listener) {
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
