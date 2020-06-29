package com.example.project_a;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

public class AccessDTO {
    String openClose,accessName;
    TextView accessTime;
    int resId;
    ArrayList<AccessDTO> unFilteredlist;
    ArrayList<AccessDTO> filteredList;
    Context context;

    public AccessDTO(String openClose, String accessName, TextView accessTime, int resId) {
        this.openClose = openClose;
        this.accessName = accessName;
        this.accessTime = accessTime;
        this.resId = resId;
    }
//    public AccessDTO(Context context, ArrayList<AccessDTO> list){
//        super();
//        this.context = context;
//        this.unFilteredlist = list;
//        this.filteredList = list;
//    }

    public ArrayList<AccessDTO> getUnFilteredlist() {
        return unFilteredlist;
    }

    public void setUnFilteredlist(ArrayList<AccessDTO> unFilteredlist) {
        this.unFilteredlist = unFilteredlist;
    }


    public ArrayList<AccessDTO> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(ArrayList<AccessDTO> filteredList) {
        this.filteredList = filteredList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getOpenClose() {
        return openClose;
    }

    public void setOpenClose(String openClose) {
        this.openClose = openClose;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public TextView getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(TextView accessTime) {
        this.accessTime = accessTime;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }


}
