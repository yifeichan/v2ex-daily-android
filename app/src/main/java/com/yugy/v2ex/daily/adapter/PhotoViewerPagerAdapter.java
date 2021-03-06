package com.yugy.v2ex.daily.adapter;

import android.support.v13.app.FragmentStatePagerAdapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import com.yugy.v2ex.daily.fragment.PhotoViewFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wuyexiong on 13-7-27.
 */
public class PhotoViewerPagerAdapter extends FragmentStatePagerAdapter {

    protected final HashMap<Object, Integer> mObjectRowMap = new HashMap<Object, Integer>();
    private ArrayList<String> mList = new ArrayList<String>();

    public PhotoViewerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final Object obj = super.instantiateItem(container, position);
        if (obj != null) {
            mObjectRowMap.put(obj, position);
        }
        return obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mObjectRowMap.remove(object);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoViewFragment.newInstance(mList.get(position), position);
    }

    @Override
    public int getItemPosition(Object object) {
        final Integer rowId = mObjectRowMap.get(object);
        if (rowId == null) {
            return PagerAdapter.POSITION_NONE;
        } else {
            return rowId;
        }
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        } else {
            return 0;
        }
    }

    public ArrayList<String> getData() {
        return mList;
    }

    public void setData(List<String> datas) {
        mList.clear();
        mList.addAll(datas);
        notifyDataSetChanged();
    }
}
