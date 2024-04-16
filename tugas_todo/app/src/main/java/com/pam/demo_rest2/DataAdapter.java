package com.pam.demo_rest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Data> data;

    public DataAdapter(Context context, ArrayList<Data> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.data_row, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data d = this.data.get(position);
        DataViewHolder vh =(DataViewHolder) holder;
        vh.tvId.setText(String.valueOf(d.getId()).toString());
        vh.tvTime.setText(d.getTime().toString());
        vh.tvWhat.setText(d.getWhat().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        private TextView tvId, tvTime, tvWhat;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvTime = itemView.findViewById(R.id.tvTime);
            this.tvWhat = itemView.findViewById(R.id.tvWhat);

        }
    }


}


