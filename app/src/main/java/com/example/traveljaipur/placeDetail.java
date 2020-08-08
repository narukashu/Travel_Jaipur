package com.example.traveljaipur;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Objects;

public class placeDetail extends AppCompatActivity {
    final ArrayList<Item> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        String itemTitle = getIntent().getStringExtra(getString(R.string.intent_extra_item_title));

        setTitle(itemTitle);

        initItems(mItems);

        int currentPlaceIndex = getItemIndexByTitle(itemTitle);

        inflateLayout(currentPlaceIndex);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    private void inflateLayout(int index) {
        ImageView placeImage = findViewById(R.id.item_image);
        placeImage.setImageResource(mItems.get(index).getImageResourceId());

        TextView placeName = findViewById(R.id.item_title);
        placeName.setText(mItems.get(index).getTitle());

        TextView placeLocation = findViewById(R.id.item_location);
        placeLocation.setText(mItems.get(index).getLocation());

        TextView PlaceHighlight = findViewById(R.id.item_hightlights);

        String[] highlights = mItems.get(index).getHighlights();

        String highlights_text = "";

        for (String highlight : highlights) {
            highlights_text += "* " + highlight + "\n\n";
        }
        PlaceHighlight.setText(highlights_text);

    }


    private int getItemIndexByTitle(String title) {
        try {
            for (int i = 0; i < mItems.size(); i++) {
                Item currentItem = mItems.get(i);
                String currentTitle = currentItem.getTitle();
                if (title.equals(currentTitle)) {
                    return i;
                }
            }
        }
        catch (Error error) {
            error.printStackTrace();
        }
        return -1;
    }

    private void initItems(ArrayList<Item> place) {

        place.add(new Item(getString(R.string.World_Trade_Park_title),
                R.drawable.city_wtp,
                getString(R.string.World_Trade_Park_location),
                getResources().getStringArray(R.array.World_Trade_Park_highlights),
                getString(R.string.World_Trade_Park_provider)));

        place.add(new Item(getString(R.string.Abhaneri_Stepwall_title),
                R.drawable.city_abhanaristepwall,
                getString(R.string.Abhaneri_Stepwall_location),
                getResources().getStringArray(R.array.Abhaneri_Stepwall_highlights),
                getString(R.string.Abhaneri_Stepwall_provider)));

        place.add(new Item(getString(R.string.Galta_ji_title),
                R.drawable.city_galtaji,
                getString(R.string.Galta_ji_location),
                getResources().getStringArray(R.array.Galta_ji_highlights),
                getString(R.string.Galta_ji_provider)));

        place.add(new Item(getString(R.string.birla_Mandir_title),
                R.drawable.city_birla,
                getString(R.string.birla_Mandir_location),
                getResources().getStringArray(R.array.birla_Mandir_highlights),
                getString(R.string.birla_Mandir_provider)));

        place.add(new Item(getString(R.string.Akshardham_title),
                R.drawable.city_akshardham,
                getString(R.string.Akshardham_location),
                getResources().getStringArray(R.array.Akshardham_highlights),
                getString(R.string.Akshardham_provider)));

        place.add(new Item(getString(R.string.Central_Park_title),
                R.drawable.city_centralpark,
                getString(R.string.Central_Park_location),
                getResources().getStringArray(R.array.Central_Park_highlights),
                getString(R.string.Central_Park_provider)));

        place.add(new Item(getString(R.string.Rajasthani_Food_title),
                R.drawable.food_rajasthani,
                getString(R.string.Rajasthani_Food_location),
                getResources().getStringArray(R.array.Rajasthani_Food_highlights),
                getString(R.string.Rajasthani_Food_provider)));

        place.add(new Item(getString(R.string.BBQ_Nation_title),
                R.drawable.food_bbq,
                getString(R.string.BBQ_Nation_location),
                getResources().getStringArray(R.array.BBQ_Nation_highlights),
                getString(R.string.BBQ_Nation_provider)));

        place.add(new Item(getString(R.string.Virasat_title),
                R.drawable.food_virasat,
                getString(R.string.Virasat_location),
                getResources().getStringArray(R.array.Virasat_highlights),
                getString(R.string.Virasat_provider)));

        place.add(new Item(getString(R.string.Jaipur_Adda_title),
                R.drawable.food_jaipur_adda,
                getString(R.string.Jaipur_Adda_location),
                getResources().getStringArray(R.array.Jaipur_Adda_highlights),
                getString(R.string.Jaipur_Adda_provider)));

        place.add(new Item(getString(R.string.ZoloCrust_title),
                R.drawable.food_zolocrust,
                getString(R.string.ZoloCrust_location),
                getResources().getStringArray(R.array.ZoloCrust_highlights),
                getString(R.string.ZoloCrust_provider)));

        place.add(new Item(getString(R.string.Rajput_Room_title),
                R.drawable.food_the_rajput_room,
                getString(R.string.Rajput_Room_location),
                getResources().getStringArray(R.array.Rajput_Room_highlights),
                getString(R.string.Rajput_Room_provider)));

        place.add(new Item(getString(R.string.Fairmont_title),
                R.drawable.lodge_fairmont,
                getString(R.string.Fairmont_location),
                getResources().getStringArray(R.array.Fairmont_highlights),
                getString(R.string.Fairmont_provider)));

        place.add(new Item(getString(R.string.Ibis_title),
                R.drawable.lodge_ibis,
                getString(R.string.Ibis_location),
                getResources().getStringArray(R.array.Ibis_highlights),
                getString(R.string.Ibis_provider)));

        place.add(new Item(getString(R.string.Radission_title),
                R.drawable.lodge_radisson,
                getString(R.string.Radission_location),
                getResources().getStringArray(R.array.Radission_highlights),
                getString(R.string.Radission_provider)));

        place.add(new Item(getString(R.string.Meridian_title),
                R.drawable.lodge_meridian,
                getString(R.string.Meridian__location),
                getResources().getStringArray(R.array.Meridian__highlights),
                getString(R.string.Meridian__provider)));

        place.add(new Item(getString(R.string.Oberoi_Palace_title),
                R.drawable.lodge_oberoi,
                getString(R.string.Oberoi_Palace_location),
                getResources().getStringArray(R.array.Oberoi_Palace_highlights),
                getString(R.string.Oberoi_Palace_provider)));

        place.add(new Item(getString(R.string.Rajasthan_Palace_title),
                R.drawable.lodge_rajasthan,
                getString(R.string.Rajasthan_Palace_location),
                getResources().getStringArray(R.array.Rajasthan_Palace_highlights),
                getString(R.string.Rajasthan_Palace_provider)));

        place.add(new Item(getString(R.string.Hawamahel_title),
                R.drawable.fort_hawamahel,
                getString(R.string.Hawamahel_location),
                getResources().getStringArray(R.array.Hawamahel_highlights),
                getString(R.string.Hawamahel_provider)));

        place.add(new Item(getString(R.string.Albert_hall_title),
                R.drawable.fort_alberthall,
                getString(R.string.Albert_hall_location),
                getResources().getStringArray(R.array.Albert_hall_highlights),
                getString(R.string.Albert_hall_provider)));

        place.add(new Item(getString(R.string.Amber_Fort_title),
                R.drawable.fort_amber,
                getString(R.string.Amber_Fort_location),
                getResources().getStringArray(R.array.Amber_Fort_highlights),
                getString(R.string.Amber_Fort_provider)));

        place.add(new Item(getString(R.string.Nahargarh_Fort_title),
                R.drawable.fort_nahargarh,
                getString(R.string.Nahargarh_Fort_location),
                getResources().getStringArray(R.array.Nahargarh_Fort_highlights),
                getString(R.string.Nahargarh_Fort_provider)));

        place.add(new Item(getString(R.string.Jantar_Mantar_title),
                R.drawable.fort_jantarmantar,
                getString(R.string.Jantar_Mantar_location),
                getResources().getStringArray(R.array.Jantar_Mantar_highlights),
                getString(R.string.Jantar_Mantar_provider)));

        place.add(new Item(getString(R.string.Jal_Mahel_title),
                R.drawable.fort_jalmahel,
                getString(R.string.Jal_Mahel_location),
                getResources().getStringArray(R.array.Jal_Mahel_highlights),
                getString(R.string.Jal_Mahel_provider)));
    }
}
