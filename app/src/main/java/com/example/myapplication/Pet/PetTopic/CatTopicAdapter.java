package com.example.myapplication.Pet.PetTopic;

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

import java.util.List;

public class CatTopicAdapter extends RecyclerView.Adapter<CatTopicAdapter.ViewHolder>{
    private List<CatTopic> data;
    private final CatTopicRecyclerViewInterface catTopicRecyclerViewInterface;



    public CatTopicAdapter(List<CatTopic> data, CatTopicRecyclerViewInterface catTopicRecyclerViewInterface) {
        this.data = data;
        this.catTopicRecyclerViewInterface = catTopicRecyclerViewInterface;
    }

    public void setFilteredList(List<CatTopic> listPet){
        this.data = listPet;
    }

    @NonNull
    @Override
    public CatTopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new CatTopicAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatTopicAdapter.ViewHolder holder, int position) {
        CatTopic item = data.get(position);

        Picasso.get().load(item.getImage()).into(holder.imageView_class);
        holder.textView.setText(item.getTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catTopicRecyclerViewInterface.onItemClick(item);
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


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_class;
        private TextView textView;
        private CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView_class = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tv1);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
