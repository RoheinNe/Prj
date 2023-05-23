package com.example.prj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class wallet_recycler extends RecyclerView.Adapter<wallet_recycler.MyViewHolder> {
    Context context;
    ArrayList<WalletModel> walletModels;

    public wallet_recycler(Context context, ArrayList<WalletModel> walletModels) {
        this.context = context;
        this.walletModels = walletModels;
    }

    @NonNull
    @Override
    public wallet_recycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.money_recycler, parent, false);
        return new wallet_recycler.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wallet_recycler.MyViewHolder holder, int position) {
        holder.date.setText(walletModels.get(position).getDate());
        holder.money.setText(walletModels.get(position).getMoney());
    }

    @Override
    public int getItemCount() {
        return walletModels.size() + 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, money;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateTF);
            money = itemView.findViewById(R.id.moneyTF);
        }
    }
}
