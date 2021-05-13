package com.example.spinner.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spinner.R;
import com.example.spinner.model.DealerModel;

import java.util.List;


public class CustomAdapter extends ArrayAdapter<DealerModel> {

    LayoutInflater flater;

    public CustomAdapter(Context context, int resouceId, int textviewId, List<DealerModel> list){

        super(context,resouceId,textviewId, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position); }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position);
    }

    private View rowview(View convertView , int position){

        DealerModel rowItem = getItem(position);
        viewHolder holder ;
        View rowview = convertView;
        if (rowview==null) {

            holder = new viewHolder();
            flater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = flater.inflate(R.layout.custom_row_gotv, null, false);

            holder.subdealer_name = (TextView) rowview.findViewById(R.id.subdealer_name);
            rowview.setTag(holder);
        }else{
            holder = (viewHolder) rowview.getTag();
        }
        holder.subdealer_name.setText(rowItem.getSubDealerName());

        return rowview;
    }

    private class viewHolder{
        TextView subdealer_name;
    }

}
