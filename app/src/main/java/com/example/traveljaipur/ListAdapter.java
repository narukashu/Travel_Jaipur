package com.example.traveljaipur;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;


@SuppressWarnings("ALL")
public class ListAdapter extends FragmentPagerAdapter {
    private Context thisContext;
    private int currentPos = -1;

    public ListAdapter(Context context, FragmentManager fm) {
        super(fm);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();
        thisContext = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            currentPos = 0;
            return new TownFragment();
        } else if (position == 1) {
            currentPos = 1;
            return new CuisineFragment();
        } else if (position == 2) {
            currentPos = 2;
            return new LodgeFragment();
        } else
            currentPos = 3;
        return new FortFragment();
    }


    @Override
    public int getCount() {
        return 4;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return thisContext.getString(R.string.category_name_City_Overview);
        } else if (position == 1) {
            return thisContext.getString(R.string.category_name_Restaurant);
        } else if (position == 2) {
            return thisContext.getString(R.string.category_name_Rajwada_Hotel);
        } else if (position == 3) {
            return thisContext.getString(R.string.category_name_Historical);
        } else {
            return "";
        }
    }

}
