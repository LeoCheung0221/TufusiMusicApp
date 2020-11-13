package com.tufusi.ft_home.view.home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tufusi.ft_home.model.CHANNEL;

/**
 * Created by LeoCheung on 2020/11/12.
 *
 * @description
 */
public class HomePageAdapter extends FragmentPagerAdapter {

    private CHANNEL[] mList;

    public HomePageAdapter(@NonNull FragmentManager fm, CHANNEL[] datas) {
        super(fm);
        mList = datas;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        int type = mList[position].getValue();
        switch (type) {
            case CHANNEL.MINE_ID:
//                return MineFragment.newInstance();
            case CHANNEL.DISCOVERY_ID:
//                return DiscoveryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
//                return FriendFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }
}