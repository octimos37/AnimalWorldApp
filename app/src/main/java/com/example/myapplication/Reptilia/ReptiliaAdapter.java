package com.example.myapplication.Reptilia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReptiliaAdapter extends RecyclerView.Adapter<ReptiliaAdapter.ViewHolder>{
    private List<Reptilia> data;
    private ReptiliaAdapter.OnItemClickListener onItemClickListener;


    public ReptiliaAdapter(List<Reptilia> data, ReptiliaAdapter.OnItemClickListener listener) {
        this.data = data;
        this.onItemClickListener = listener;
    }

    public void setFilteredList(List<Reptilia> listMammals){
        this.data = listMammals;
    }

    @NonNull
    @Override
    public ReptiliaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        ReptiliaAdapter.ViewHolder viewHolder = new ReptiliaAdapter.ViewHolder(view);

        view.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Reptilia item = data.get(position);
                String itemId = item.getOrdoID();
                onItemClickListener.onItemClick(Integer.parseInt(itemId));
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ReptiliaAdapter.ViewHolder holder, int position) {
        Reptilia item = data.get(position);

        Picasso.get().load(item.getImageOrdo()).into(holder.imageView_class);
        holder.textViewE.setText(item.getOrdoNameE());
        holder.textViewTV.setText(item.getOrdoNameTV());
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(int itemId);
    }

    public void setOnItemClickListener(ReptiliaAdapter.OnItemClickListener listener) {
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
