package com.example.afreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    //DataSource
    String[] elements = {"blue", "Red", "Green"};

    public CustomAdapter(Context context, String[] elements) {
        this.context = context;
        this.elements = elements;
    }



    @Override
    public int getCount() {
        return elements.length;
    }

    @Override
    public Object getItem(int i) {
        return elements[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //This is the main method, practice it again

        ViewHolder viewHolder;

        if(view == null){
            // If view is empty, it means now we are creating this new view
            view = LayoutInflater.from(context).inflate(R.layout.custom_adapter_list_item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.tvInCA = view.findViewById(R.id.customAdaptorTV);
            view.setTag(view);
        }
        else{
            //Reusing the existing view
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvInCA.setText(elements[i]);

        return view;


    }
    static class ViewHolder{
        TextView tvInCA;
    }
}
