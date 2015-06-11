package com.vivek.template;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Shiva on 10-06-2015.
 */
public class PagerAdapter_for_ViewPager extends PagerAdapter {

   LayoutInflater layoutInflater;

    Context context;
    int[] f;
    public  PagerAdapter_for_ViewPager(Context context , int[] f){
        this.context = context;
        this.f = f;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView screenshots;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.preview_image, container , false);
        screenshots = (ImageView) v.findViewById(R.id.image);
        screenshots.setImageResource(f[position]);
        ((ViewPager)container).addView(v);



        return v;
    }

    @Override
    public int getCount() {
        return f.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == ((LinearLayout)o);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
