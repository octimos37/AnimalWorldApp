package com.example.myapplication.TestudinesFamilies.Testudinidae;

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
import com.example.myapplication.TestudinesFamilies.Testudinidae.Testudinidae;
import com.example.myapplication.TestudinesFamilies.Testudinidae.TestudinidaeAdapter;
import com.example.myapplication.TestudinesFamilies.Testudinidae.TestudinidaeRecyclerViewInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TestudinidaeAdapter extends RecyclerView.Adapter<TestudinidaeAdapter.ViewHolder>{
    private Context context;
    private List<Testudinidae> data;
    private List<Testudinidae> filteredList;
    private TestudinidaeAdapter adapter;
    private final com.example.myapplication.TestudinesFamilies.Testudinidae.TestudinidaeRecyclerViewInterface TestudinidaeRecyclerViewInterface;


    public TestudinidaeAdapter(List<Testudinidae> data, TestudinidaeRecyclerViewInterface TestudinidaeRecyclerViewInterface) {
        this.data = data;
        this.TestudinidaeRecyclerViewInterface = TestudinidaeRecyclerViewInterface;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Testudinidae> listTestudinidae){
        this.data = listTestudinidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TestudinidaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new TestudinidaeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestudinidaeAdapter.ViewHolder holder, int position) {
        Testudinidae item = data.get(position);

        Picasso.get().load(item.getImage_path()).into(holder.imageView);

        holder.textView.setText(item.getTextData());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestudinidaeRecyclerViewInterface.onItemClick(item);
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
