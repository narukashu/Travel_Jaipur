package com.example.traveljaipur;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CuisineFragment extends Fragment {
    public CuisineFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(getString(R.string.Rajasthani_Food_title),
                R.drawable.food_rajasthani,
                getString(R.string.Rajasthani_Food_location)));

        items.add(new Item(getString(R.string.BBQ_Nation_title),
                R.drawable.food_bbq,
                getString(R.string.BBQ_Nation_location)));

        items.add(new Item(getString(R.string.Virasat_title),
                R.drawable.food_virasat,
                getString(R.string.Virasat_location)));

        items.add(new Item(getString(R.string.Jaipur_Adda_title),
                R.drawable.food_jaipur_adda,
                getString(R.string.Jaipur_Adda_location)));

        items.add(new Item(getString(R.string.ZoloCrust_title),
                R.drawable.food_zolocrust,
                getString(R.string.ZoloCrust_location)));

        items.add(new Item(getString(R.string.Rajput_Room_title),
                R.drawable.food_the_rajput_room,
                getString(R.string.Rajput_Room_location)));

        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item currentItem = items.get(i);

                Intent itemDetailIntent = new Intent(getContext(), placeDetail.class);

                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_title),
                        currentItem.getTitle());

                startActivity(itemDetailIntent);
            }
        });

        return rootView;
    }

}