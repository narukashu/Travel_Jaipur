package com.example.traveljaipur;

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

public class ItemAdapter extends ArrayAdapter<Item> {

    static class ViewHolder {
        TextView title;
        TextView location;
        ImageView image;
    }

    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);
        ViewHolder holder = new ViewHolder();

        holder.title = listItemView.findViewById(R.id.title);
        holder.title.setText(currentItem.getTitle());

        holder.location = listItemView.findViewById(R.id.location);
        holder.location.setText(currentItem.getLocation());

        holder.image = listItemView.findViewById(R.id.image);
        holder.image.setImageResource(currentItem.getImageResourceId());


        return listItemView;
    }

}
