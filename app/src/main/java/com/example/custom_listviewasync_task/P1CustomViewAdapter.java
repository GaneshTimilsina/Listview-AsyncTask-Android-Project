package com.example.custom_listviewasync_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class P1CustomViewAdapter extends ArrayAdapter<P1DataItem> {
    Context context;
    String abc;
    ArrayList<P1DataItem> arrayList = new ArrayList<>();


    public P1CustomViewAdapter(Context context, int textViewResouceId, ArrayList<P1DataItem> objects){
        super(context,textViewResouceId,objects);
        this.context = context;
        arrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.p1mylist_view,null);
        TextView textViewitemname = (TextView) view.findViewById(R.id.itemtitle);
        TextView textViewitemdesc = (TextView) view.findViewById(R.id.itemdesc);
        ImageView imageViewitem = (ImageView) view.findViewById(R.id.itemimage);


        textViewitemname.setText(arrayList.get(position).getItemName());
        textViewitemdesc.setText(arrayList.get(position).getItemDesc());
        imageViewitem.setImageResource(arrayList.get(position).getItemImage());


        return view;

    }

}
