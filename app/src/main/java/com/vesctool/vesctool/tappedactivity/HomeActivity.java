package com.vesctool.vesctool.tappedactivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.vesctool.vesctool.R;
import com.vesctool.vesctool.fragment.AppCfgFragment;
import com.vesctool.vesctool.fragment.DeveloperFragment;
import com.vesctool.vesctool.fragment.FirmwareFragment;
import com.vesctool.vesctool.fragment.HomeFragment;
import com.vesctool.vesctool.fragment.MotorCfgFragment;
import com.vesctool.vesctool.fragment.ProfileFragment;
import com.vesctool.vesctool.fragment.RTDataFragment;
import com.vesctool.vesctool.fragment.TerminalFragment;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String[] pageTitle = {"START", "RT DATA", "PROFILES","MOTOR CFG","APP CFG","FIRMWARE","TERMINAL","DEVELOPER"};
    /*private int[] tabIcons = {
            R.drawable.home,
            R.drawable.home,
            //R.drawable.search,
            R.drawable.home,
            R.drawable.home,
            R.drawable.home,
            //R.drawable.search,
            R.drawable.home,

    };*/

    int screenPosition = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        for (int i = 0; i < 8; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        toolbar = findViewById(R.id.toolbar);

        //setupTabIcons();
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        mViewPager.addOnPageChangeListener(onPageChangeListener);


        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                // tab.setIcon(R.drawable.fav);
                //tab.getIcon().setColorFilter(Color.parseColor("#60b246"), PorterDuff.Mode.SRC_IN);


                //positionScreen = tab.getPosition();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });





    }

    /*private void setupTabIcons() {

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);


        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#60b246"), PorterDuff.Mode.SRC_IN);

    }*/


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                //positionScreen = 0;
                return new HomeFragment();
            } else if (position == 1) {
                // positionScreen = 1;
                return new RTDataFragment();
            } else if (position == 2) {
                //positionScreen = 2;
                return new ProfileFragment();
            }else if (position == 3) {
                //positionScreen = 2;
                return new MotorCfgFragment();
            }else if (position == 4) {
                //positionScreen = 2;
                return new AppCfgFragment();
            }else if (position == 5) {
                //positionScreen = 2;
                return new FirmwareFragment();
            }else if (position == 6) {
                //positionScreen = 2;
                return new TerminalFragment();
            }else if (position == 7) {
                //positionScreen = 2;
                return new DeveloperFragment();
            }
            else
                return new HomeFragment();

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 8;
        }

    }


    ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            screenPosition=i;

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
