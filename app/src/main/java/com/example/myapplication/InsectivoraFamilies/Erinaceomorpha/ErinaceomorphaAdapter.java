package com.example.myapplication.InsectivoraFamilies.Erinaceomorpha;

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

public class ErinaceomorphaAdapter extends RecyclerView.Adapter<ErinaceomorphaAdapter.ViewHolder>{
    private Context context;
    private List<Erinaceomorpha> data;
    private List<Erinaceomorpha> filteredList;
    private ErinaceomorphaAdapter adapter;
    private final ErinaceomorphaRecyclerViewInterface ErinaceomorphaRecyclerViewInterface;


    public ErinaceomorphaAdapter(List<Erinaceomorpha> data, ErinaceomorphaRecyclerViewInterface ErinaceomorphaRecyclerViewInterface) {
        this.data = data;
        this.ErinaceomorphaRecyclerViewInterface = ErinaceomorphaRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Erinaceomorpha> listErinaceomorpha){
        this.data = listErinaceomorpha;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ErinaceomorphaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new ErinaceomorphaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ErinaceomorphaAdapter.ViewHolder holder, int position) {
        Erinaceomorpha item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ErinaceomorphaRecyclerViewInterface.onItemClick(item);
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
