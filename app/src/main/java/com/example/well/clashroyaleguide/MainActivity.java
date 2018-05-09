package com.example.well.clashroyaleguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.well.clashroyaleguide.view.adapter.PageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTabs();
    }

    private void setTabs() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        tabLayout.removeAllTabs();

        tabLayout.addTab(tabLayout.newTab().setText("Arena"));
        tabLayout.addTab(tabLayout.newTab().setText("Cards"));
        tabLayout.addTab(tabLayout.newTab().setText("Decks"));
        tabLayout.addTab(tabLayout.newTab().setText("Player"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final PageAdapter pageAdapter = new PageAdapter(fragmentManager);
        viewPager.setAdapter(pageAdapter);
        viewPager.setOffscreenPageLimit(tabLayout.getTabCount());
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
