package com.example.myapplication.SerpentesFamilies.Pythonidae;

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
import com.example.myapplication.SerpentesFamilies.Pythonidae.Pythonidae;
import com.example.myapplication.SerpentesFamilies.Pythonidae.PythonidaeAdapter;
import com.example.myapplication.SerpentesFamilies.Pythonidae.PythonidaeRecyclerViewInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PythonidaeAdapter extends RecyclerView.Adapter<PythonidaeAdapter.ViewHolder>{
    private Context context;
    private List<Pythonidae> data;
    private List<Pythonidae> filteredList;
    private PythonidaeAdapter adapter;
    private final com.example.myapplication.SerpentesFamilies.Pythonidae.PythonidaeRecyclerViewInterface PythonidaeRecyclerViewInterface;


    public PythonidaeAdapter(List<Pythonidae> data, PythonidaeRecyclerViewInterface PythonidaeRecyclerViewInterface) {
        this.data = data;
        this.PythonidaeRecyclerViewInterface = PythonidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Pythonidae> listPythonidae){
        this.data = listPythonidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PythonidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new PythonidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PythonidaeAdapter.ViewHolder holder, int position) {
        Pythonidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PythonidaeRecyclerViewInterface.onItemClick(item);
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
