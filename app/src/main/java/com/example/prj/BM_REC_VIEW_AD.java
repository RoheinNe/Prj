package com.example.prj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BM_REC_VIEW_AD extends RecyclerView.Adapter<BM_REC_VIEW_AD.MyViewHolder>{
    Context context;
    ArrayList<BusModel> busModels;

    public BM_REC_VIEW_AD(Context context, ArrayList<BusModel> busModels) {
        this.context = context;
        this.busModels = busModels;
    }

    @NonNull
    @Override
    public BM_REC_VIEW_AD.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new BM_REC_VIEW_AD.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BM_REC_VIEW_AD.MyViewHolder holder, int position) {
        holder.busName.setText(busModels.get(position).getBusName());
        holder.busDate.setText(busModels.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return busModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView busName, busDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            busName = itemView.findViewById(R.id.titleTF);
            busDate = itemView.findViewById(R.id.timeTF);
        }
    }
}


