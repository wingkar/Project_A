package com.example.project_a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccessRecordAdapter extends RecyclerView.Adapter<AccessRecordAdapter.ViewHolder> implements OnAccessItemClickListener ,Filterable{
    ArrayList<AccessDTO> list = new ArrayList<>();
    OnAccessItemClickListener listener;
    Context context;
    ArrayList<AccessDTO> unFilteredlist;
    ArrayList<AccessDTO> filteredList;
    //public AccessRecordAdapter(){};
    public AccessRecordAdapter(Context context,ArrayList<AccessDTO> list) {
        super();
        this.context = context;
        this.unFilteredlist = list;
        this.filteredList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_access_record_item, parent, false);

        return new ViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AccessDTO item = filteredList.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }
    public void addItem(AccessDTO item){
        filteredList.add(item);
        unFilteredlist.add(item);
    }

    public AccessDTO getItem(int position){ return filteredList.get(position);}
    public void setOnItemClickListener(OnAccessItemClickListener listener){
        this.listener = listener;
    }

    public void setItem(int position, AccessDTO item){
        filteredList.set(position, item);
}
    @Override
    public void onItemClick(ViewHolder holderm, View view, int position) {
        if(listener != null){
            listener.onItemClick(holderm, view, position);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    filteredList = unFilteredlist;
                } else {
                    ArrayList<AccessDTO> filteringList = new ArrayList<>();
                    for(AccessDTO dto : unFilteredlist){
                        if(dto.getAccessName().toLowerCase().contains((charString.toLowerCase()))) {

                            filteringList.add(dto);
                        }
                    }
                    filteredList = filteringList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<AccessDTO>) results.values;
                notifyDataSetChanged();
            }
        };
    }










    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView accessImage;
        TextView openClose,accessName,accessTime;
        EditText editText;
        public ViewHolder(@NonNull View itemView, final OnAccessItemClickListener listener) {
            super(itemView);
            accessImage = itemView.findViewById(R.id.accessImage);
            openClose = itemView.findViewById(R.id.openClose);
            accessName = itemView.findViewById(R.id.accessName);
            accessTime = itemView.findViewById(R.id.accessTime);
            //editText = itemView.findViewById(R.id.edittext);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = sdfNow.format(date);



        public void setItem(AccessDTO item){
            accessTime.setText(formatDate);
            openClose.setText(item.getOpenClose());
            accessName.setText(item.getAccessName());
            accessImage.setImageResource(item.getResId());
        }

    }
}
