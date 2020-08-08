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

public class FortFragment extends Fragment {
    public FortFragment() {
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);
        final ArrayList<Item> inner_Details = new ArrayList<>();

        inner_Details.add(new Item(getString(R.string.Hawamahel_title),
                R.drawable.fort_hawamahel,
                getString(R.string.Hawamahel_location)));

        inner_Details.add(new Item(getString(R.string.Albert_hall_title),
                R.drawable.fort_alberthall,
                getString(R.string.Albert_hall_location)));

        inner_Details.add(new Item(getString(R.string.Amber_Fort_title),
                R.drawable.fort_amber,
                getString(R.string.Amber_Fort_location)));

        inner_Details.add(new Item(getString(R.string.Nahargarh_Fort_title),
                R.drawable.fort_nahargarh,
                getString(R.string.Nahargarh_Fort_location)));

        inner_Details.add(new Item(getString(R.string.Jantar_Mantar_title),
                R.drawable.fort_jantarmantar,
                getString(R.string.Jantar_Mantar_location)));

        inner_Details.add(new Item(getString(R.string.Jal_Mahel_title),
                R.drawable.fort_jalmahel,
                getString(R.string.Jal_Mahel_location)));

        final ItemAdapter adapter = new ItemAdapter(getActivity(), inner_Details);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item Current_list = inner_Details.get(i);

                Intent itemDetailIntent = new Intent(getContext(), placeDetail.class);

                itemDetailIntent.putExtra(getString(R.string.intent_extra_item_title),
                        Current_list.getTitle());

                startActivity(itemDetailIntent);
            }
        });
        return rootView;
    }
}