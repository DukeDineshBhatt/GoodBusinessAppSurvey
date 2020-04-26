package com.app.goodbusinessappsurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

public class CompletedProfile extends AppCompatActivity {

    TabLayout tabs;
    CustomViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_profile);

        tabs = findViewById(R.id.tabLayout2);
        pager = findViewById(R.id.pager);

        tabs.addTab(tabs.newTab().setText("PERSONAL"));
        tabs.addTab(tabs.newTab().setText("PROFESSIONAL"));


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);


        tabs.getTabAt(0).setText("PERSONAL");
        tabs.getTabAt(1).setText("PROFESSIONAL");

    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                CompletedPersonal frag = new CompletedPersonal();
                frag.setData(pager);
                return frag;
            } else {
                return new CompletedProfessional();
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
