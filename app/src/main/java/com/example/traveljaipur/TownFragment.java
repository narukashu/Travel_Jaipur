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

//Create TownFragment
public class TownFragment extends Fragment {
    //Create TownFragment constructor
    public TownFragment() {
        //empty constructor
    }

    //Override onStart method
    @Override
    public void onStop() {
        super.onStop();
    }

    //Override onCreateView method
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //First, create a rootView and inflate layout from item_listview
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        //Create a ArrayList of Item
        final ArrayList<Item> items = new ArrayList<Item>();

        //Add list data
        items.add(new Item(getString(R.string.World_Trade_Park_title),
                R.drawable.city_wtp,
                getString(R.string.World_Trade_Park_location)));

        items.add(new Item(getString(R.string.Abhaneri_Stepwall_title),
                R.drawable.city_abhanaristepwall,
                getString(R.string.Abhaneri_Stepwall_location)));

        items.add(new Item(getString(R.string.Galta_ji_title),
                R.drawable.city_galtaji,
                getString(R.string.Galta_ji_location)));

        items.add(new Item(getString(R.string.birla_Mandir_title),
                R.drawable.city_birla,
                getString(R.string.birla_Mandir_location)));

        items.add(new Item(getString(R.string.Akshardham_title),
                R.drawable.city_akshardham,
                getString(R.string.Akshardham_location)));

        items.add(new Item(getString(R.string.Central_Park_title),
                R.drawable.city_centralpark,
                getString(R.string.Central_Park_location)));

        //Create an ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        //Get list view
        ListView listView = rootView.findViewById(R.id.list);

        //Bind with adapter
        listView.setAdapter(adapter);

        //Create a onClickLIstener when listview item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get current item index
                Item currentItem = items.get(i);

                //Create an Intent
                Intent itemDetailIntent = new Intent(getContext(), placeDetail.class);

                //Add an extra var; ITEM_TITEL so we can reference in the placeDetail activity
                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_title),
                        currentItem.getTitle());

                //Start the intent
                startActivity(itemDetailIntent);
            }
        });

        //Return the view
        return rootView;
    }
}
