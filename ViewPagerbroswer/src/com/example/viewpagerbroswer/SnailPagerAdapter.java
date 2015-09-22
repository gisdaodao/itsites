package com.example.viewpagerbroswer;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;


public class SnailPagerAdapter extends PagerAdapter {
    private List<View> viewList;
    private List<String> stringList;
    public SnailPagerAdapter(List<View> viewList,List<String> stringList)
    {
        this.viewList=viewList;
        this.stringList=stringList;
    }

    /**
     * 获取页卡的数量
     * @return
     */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /**
     *  判断当前的View是否来自于对象
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * 实例化一个页卡
     */

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    /**
     * 销毁一个页卡
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    /**
     * 设置Viewpager页卡的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
