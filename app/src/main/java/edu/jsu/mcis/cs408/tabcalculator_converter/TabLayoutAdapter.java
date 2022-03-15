package edu.jsu.mcis.cs408.tabcalculator_converter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment) {super(fragment);}

    @NonNull
    @Override
    public Fragment createFragment(int position){
        Fragment fragment;

        Bundle args = new Bundle();
        switch (position){
            case 0:
                fragment = new TipFragment();
                args.putInt(TipFragment.ARG_ID, position + 1);
                break;
            case 1:
                fragment = new TempFragment();
                args.putInt(TempFragment.ARG_ID, position + 1);
                break;
            default:
                fragment = new DistanceFragment();
                args.putInt(DistanceFragment.ARG_ID, position + 1);
        }

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getItemCount() { return NUM_TABS; }
}
