package poly.manhnt.md9_datn_fmodel.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


import android.os.Handler;
import android.os.Looper;

import poly.manhnt.md9_datn_fmodel.Views.HomeScreen.Fragments.Frag1;
import poly.manhnt.md9_datn_fmodel.Views.HomeScreen.Fragments.Frag2;
import poly.manhnt.md9_datn_fmodel.Views.HomeScreen.Fragments.Frag3;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    private int currentPosition = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragmentList.add(new Frag1());
        fragmentList.add(new Frag2());
        fragmentList.add(new Frag3());

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
