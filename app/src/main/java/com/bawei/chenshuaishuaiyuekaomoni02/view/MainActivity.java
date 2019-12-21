package com.bawei.chenshuaishuaiyuekaomoni02.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.chenshuaishuaiyuekaomoni02.R;
import com.bawei.chenshuaishuaiyuekaomoni02.view.fragment.BeijingFragment;
import com.bawei.chenshuaishuaiyuekaomoni02.view.fragment.HomeFragment;
import com.bawei.chenshuaishuaiyuekaomoni02.view.fragment.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        list.add(new HomeFragment());
        BeijingFragment beijingFragment = new BeijingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("beijing","北京");
        beijingFragment.setArguments(bundle);
        list.add(beijingFragment);
        MyFragment myFragment = new MyFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("wode","我的");
        myFragment.setArguments(bundle1);
        list.add(myFragment);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position%list.size()){
                    case 0:
                        radioGroup.check(R.id.btn_1);
                        break;
                    case 1:
                        radioGroup.check(R.id.btn_2);
                        break;
                    case 2:
                        radioGroup.check(R.id.btn_3);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.btn_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.btn_3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
