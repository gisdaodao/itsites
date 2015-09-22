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
     * ��ȡҳ��������
     * @return
     */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /**
     *  �жϵ�ǰ��View�Ƿ������ڶ���
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * ʵ����һ��ҳ��
     */

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    /**
     * ����һ��ҳ��
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    /**
     * ����Viewpagerҳ���ı���
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
