package com.vivek.template;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Shiva on 10-06-2015.
 */
public class ViewPagerActivity extends FragmentActivity {


    private ViewPager viewPager;
    int[] f;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        f = new int[]{R.drawable.one, R.drawable.two , R.drawable.three ,
        R.drawable.four , R.drawable.five , R.drawable.six , R.drawable.seven ,
        R.drawable.eight ,R.drawable.nine , R.drawable.ten ,
        R.drawable.eleven , R.drawable.tweleve ,R.drawable.thirteen ,
        R.drawable.fourteen , R.drawable.fifteen , R.drawable.sixteen ,
        R.drawable.seventeen };

        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter_for_ViewPager(ViewPagerActivity.this, f);
        viewPager.setAdapter(pagerAdapter);

    }
}
/*
    private class ScreenSlide extends FragmentStatePagerAdapter {
        public ScreenSlide(FragmentManager f) {
            super(f);
        }

        @Override
        public Fragment getItem(int i) {
            return new fragment();
        }

        @Override
        public int getCount() {
            return num;
        }


    }
}
*/