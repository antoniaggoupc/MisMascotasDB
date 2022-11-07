package com.antoniaggo.mismascotas.adapter;

import com.antoniaggo.mismascotas.R;
import com.antoniaggo.mismascotas.fragment.ProfileFragment;
import com.antoniaggo.mismascotas.fragment.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdapter  extends FragmentStateAdapter {

    private ArrayList<Fragment> fragmentList;

    public enum Tab {

        HOME(0, R.string.tab_home, R.drawable.ic_icons8_home_page_48),
        PET(1, R.string.tab_mascota, R.drawable.ic_icons8_puppy_48);

        final public int title;
        final public int icon;
        final public int position;

        Tab(int position, @StringRes int title, @DrawableRes int icon) {
            this.position = position;
            this.title = title;
            this.icon = icon;
        }

        private static final Map<Integer,Tab> map;
        static {
            map = new HashMap<>();
            for (Tab t : Tab.values()) {
                map.put(t.position, t);
            }
        }

        public static Tab byPosition(int position) {
            return map.get(position);
        }
    }

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> fragmentList) {
        super(fragmentManager,lifecycle);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == Tab.HOME.position)
            return new RecyclerViewFragment();
        else if (position == Tab.PET.position)
            return new ProfileFragment();
        else
            throw new IllegalArgumentException("unknown position " + position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
