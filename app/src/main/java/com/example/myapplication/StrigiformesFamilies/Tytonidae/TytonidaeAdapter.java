package com.example.myapplication.StrigiformesFamilies.Tytonidae;

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
import com.example.myapplication.StrigiformesFamilies.Tytonidae.Tytonidae;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeAdapter;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeRecyclerViewInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TytonidaeAdapter extends RecyclerView.Adapter<TytonidaeAdapter.ViewHolder>{
    private Context context;
    private List<Tytonidae> data;
    private List<Tytonidae> filteredList;
    private TytonidaeAdapter adapter;
    private final com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeRecyclerViewInterface TytonidaeRecyclerViewInterface;


    public TytonidaeAdapter(List<Tytonidae> data, TytonidaeRecyclerViewInterface TytonidaeRecyclerViewInterface) {
        this.data = data;
        this.TytonidaeRecyclerViewInterface = TytonidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Tytonidae> listTytonidae){
        this.data = listTytonidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TytonidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new TytonidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TytonidaeAdapter.ViewHolder holder, int position) {
        Tytonidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TytonidaeRecyclerViewInterface.onItemClick(item);
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
