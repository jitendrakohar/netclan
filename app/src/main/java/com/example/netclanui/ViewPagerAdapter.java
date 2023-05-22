package com.example.netclanui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.netclanui.fragment.groupfragments;
import com.example.netclanui.fragment.Fragment2;
import com.example.netclanui.fragment.Fragment3;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int[] imageList = {R.drawable.ic_group, R.drawable.bag, R.drawable.ic_house};
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        // Return the Fragment for the corresponding tab position
        switch (position) {
            case 0:
                return new groupfragments();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Return the total number of tabs
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the title of each tab
//        switch (position) {
//            case 0:
//                return "Tab 1";
//            case 1:
//                return "Tab 2";
//            case 2:
//                return "Tab 3";
//            default:
//                return null;
//        }

        // Initialize drawable
        Drawable drawable = ContextCompat.getDrawable(context.getApplicationContext()
                , imageList[position]);

        // set bound
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());

        // Initialize spannable image
        SpannableString spannableString = new SpannableString(" ");

        // Initialize image span
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);

        // Set span
        spannableString.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // return spannable string
        return spannableString;

    }
}
