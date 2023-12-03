package com.example.myapplication.Quiz;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder>{
    private List<Quiz> data;
    private RecyclerView recyclerView;
    private Button btnA;

    private OnItemClickListener onItemClickListener;

    public QuizAdapter(List<Quiz> data) {
        this.data = data;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setFilteredList(List<Quiz> listMammals){
        this.data = listMammals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        ViewHolder viewHolder = new QuizAdapter.ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull QuizAdapter.ViewHolder holder, int position) {
        Quiz item = data.get(position);

        Picasso.get().load(item.getImage()).into(holder.imageView_class);
        holder.id.setText(item.getId());
        holder.qa.setText(item.getQA());
        holder.qb.setText(item.getQB());
        holder.qc.setText(item.getQC());
        holder.qd.setText(item.getQD());
        holder.ans.setText(item.getAns());
        holder.recyclerView = recyclerView;

    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView_class;
        private TextView id;
        private TextView qa;
        private TextView qb;
        private TextView qc;
        private TextView qd;
        private Button btnA;
        private Button btnB;
        private Button btnC;
        private Button btnD;
        private TextView ans;
        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView_class = itemView.findViewById(R.id.iv_question_pic);
            id = itemView.findViewById(R.id.txt_numQues);
            qa = itemView.findViewById(R.id.btn_a);
            qb = itemView.findViewById(R.id.btn_b);
            qc = itemView.findViewById(R.id.btn_c);
            qd = itemView.findViewById(R.id.btn_d);
            ans = itemView.findViewById(R.id.tv_ans);
            recyclerView = itemView.findViewById(R.id.rcvQuiz);

            View.OnClickListener buttonClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clickedButton = (Button) v;
                    String clickedButtonText = clickedButton.getText().toString().trim();

                    if (clickedButtonText.equals(ans.getText().toString().trim())) {
                        String message = clickedButtonText + " is Correct";
                        Toast.makeText(itemView.getContext(), message, Toast.LENGTH_SHORT).show();
                        clickedButton.setBackgroundColor(Color.GREEN);

//                        int nextPosition = getAdapterPosition() + 1;
//                        if (nextPosition < data.size()) {
//                            recyclerView.smoothScrollToPosition(nextPosition);
//                        }
                    } else {
                        String message = clickedButtonText + " is Wrong";
                        Toast.makeText(itemView.getContext(), message, Toast.LENGTH_SHORT).show();
                        clickedButton.setBackgroundColor(Color.RED);
                    }
                }
            };
            qa.setOnClickListener(buttonClickListener);
            qb.setOnClickListener(buttonClickListener);
            qc.setOnClickListener(buttonClickListener);
            qd.setOnClickListener(buttonClickListener);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
