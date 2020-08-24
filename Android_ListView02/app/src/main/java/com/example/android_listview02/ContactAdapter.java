package com.example.android_listview02;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.customview.widget.ViewDragHelper;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<ContactModel> listContacts;
    private Activity activity;

    public ContactAdapter(List<ContactModel> listContacts, Activity activity){
        this.listContacts = listContacts;
        this.activity = activity;
    }
    @Override
    public int getCount(){
        return listContacts.size();
    }
    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        if (converView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            converView = inflater.inflate(R.layout.item_contact,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView)converView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView)converView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView)converView.findViewById(R.id.ivAvatar);
            converView.setTag(holder);

        }
        ViewHolder holder = (ViewHolder) converView.getTag();
        ContactModel model = listContacts.get(position);
        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhone());
        holder.ivAvatar.setImageResource(model.getImage());
        return converView;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
    }

}

