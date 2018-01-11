package xyz.einandartun.news.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by einandartun on 1/7/18.
 */

public class NewsByCategoryAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragment;
    private List<String> mTabTitles;

    public NewsByCategoryAdapter(FragmentManager fm) {
        super(fm);
        mFragment = new ArrayList<>();
        mTabTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }

    public  void addTab(String tabTitle, Fragment fragment){
        mTabTitles.add(tabTitle);
        mFragment.add(fragment);
        notifyDataSetChanged();
    }
}
