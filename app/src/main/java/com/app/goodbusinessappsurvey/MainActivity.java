package com.app.goodbusinessappsurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    CustomViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabs = findViewById(R.id.tabLayout2);
        pager = findViewById(R.id.pager);

        tabs.addTab(tabs.newTab().setText("Ongoing"));
        tabs.addTab(tabs.newTab().setText("Completed"));


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);

        pager.setPagingEnabled(true);


        tabs.getTabAt(0).setText("Ongoing");
        tabs.getTabAt(1).setText("Completed");

    }


    class PagerAdapter extends FragmentStatePagerAdapter
    {



        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
            {
                Ongoing frag = new Ongoing();
                frag.setData(pager);
                return frag;
            }
            else
            {
                return new Completed();
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
