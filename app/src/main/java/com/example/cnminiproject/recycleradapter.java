package com.example.cnminiproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.myviewholder> {

    ArrayList<String> meslist;
    String flag;
    Context parentcontext;

    public recycleradapter(ArrayList<String> meslist, String flag, Context parentcontext) {
        this.meslist = meslist;
        this.flag = flag;
        this.parentcontext = parentcontext;
    }

    @NonNull
    @Override
    public recycleradapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parentcontext).inflate(R.layout.customrecyclerlayout,parent,false);
        TextView tvtemp;
        tvtemp = view.findViewById(R.id.tvframebit);
        switch (viewType)
        {
            case 1:tvtemp.setBackgroundColor(Color.parseColor("#11F1E2"));
                    break;
            case 2:tvtemp.setBackgroundColor(Color.parseColor("#9713F5"));
                break;
            case 3:tvtemp.setBackgroundColor(Color.parseColor("#000000"));
                   tvtemp.setTextColor(Color.WHITE);
                break;
            case 4:tvtemp.setBackgroundColor(Color.parseColor("#F1F911"));
                break;
            case 5:tvtemp.setBackgroundColor(Color.parseColor("#F1F911"));
                break;
            case 6:tvtemp.setBackgroundColor(Color.parseColor("#F1F911"));
                break;
        }
        myviewholder holder = new myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycleradapter.myviewholder holder, int position) {
        holder.tvframebit.setText(meslist.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0 || position==(meslist.size()-1))
        {
            return 1;
        }
        else if(meslist.get(position).equals("header") || meslist.get(position).equals("trailer")){
            return 2;
        }
        else if(meslist.get(position).equals("ESC") && !meslist.get(position-1).equals("ESC")){
            return 3;
        }
        else if(meslist.get(position).equals(flag) && meslist.get(position-1).equals("ESC"))
        {
            return 4;
        }
        else if(meslist.get(position).equals("ESC")&&meslist.get(position-1).equals("ESC"))
        {
            return 5;
        }
        else{
            return 6;
        }
    }

    @Override
    public int getItemCount() {
        return meslist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView tvframebit;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            tvframebit = itemView.findViewById(R.id.tvframebit);
        }
    }
}
