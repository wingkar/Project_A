package com.example.homekeeper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>  {
    ArrayList<Event> items = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.homekeeper_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        final Event item = items.get(position);
        holder.setItem(item);
        holder.TextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Event item){
        items.add(item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView TextView1,TextView2,TextView3;
        ImageView imageView;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TextView1 = itemView.findViewById(R.id.textView1);
            TextView2 = itemView.findViewById(R.id.textView2);
            TextView3 = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView);
            parentLayout=itemView.findViewById(R.id.parentLayout);
        }

        public void setItem(Event item){
            TextView1.setText(item.getEvent1());
            TextView2.setText(item.getEvent2());
            TextView3.setText(item.getDate());
            imageView.setImageResource(item.getResId());
        }
    }
}
