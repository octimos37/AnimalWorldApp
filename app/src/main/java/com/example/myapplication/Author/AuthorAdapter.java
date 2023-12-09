package com.example.myapplication.Author;

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

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder>{
    private Context context;
    private List<Author> data;
    private List<Author> filteredList;


    public AuthorAdapter(List<Author> data) {
        this.data = data;
        this.filteredList = new ArrayList<>(data);
    }

    public void setFilteredList(List<Author> listCanidae){
        this.data = listCanidae;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AuthorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.author_items, parent, false);
        return new AuthorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorAdapter.ViewHolder holder, int position) {
        Author item = data.get(position);

        Picasso.get().load(item.getImage()).into(holder.imageView);

        holder.textView.setText(item.getFullName());
        holder.textView1.setText(item.getEmail());
        holder.textView2.setText(item.getPhone());
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
        private TextView textView1;
        private TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tv1);
            textView1 = itemView.findViewById(R.id.tv2);
            textView2 = itemView.findViewById(R.id.tv3);
        }
    }
}
