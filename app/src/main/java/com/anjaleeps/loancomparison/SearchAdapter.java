package com.anjaleeps.loancomparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SearchAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Entry> listItemStorage;

    public SearchAdapter(Context context, List<Entry> querySuggestions) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemStorage = querySuggestions;
    }

    @Override
    public int getCount() {
        return listItemStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return listItemStorage.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.layout_suggestion, parent, false);
            listViewHolder.dbItem = (TextView)convertView.findViewById(R.id.suggestion);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.dbItem.setText(listItemStorage.get(position).getString());
        return convertView;
    }
    static class ViewHolder{
        TextView dbItem;
    }

}