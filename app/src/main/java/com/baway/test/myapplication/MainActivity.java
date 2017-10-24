package com.baway.test.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private List<Fragment> list = new ArrayList<>();
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    /**
     * 漫画
     */
    private RadioButton mRadio;
    /**
     * 发现
     */
    private RadioButton mRadio1;
    /**
     * v社区
     */
    private RadioButton mRadio2;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);

        initView();
        mVp.setCurrentItem(0);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio:
                        mVp.setCurrentItem(0);
                        break;
                    case R.id.radio1:
                        mVp.setCurrentItem(1);
                        break;
                    case  R.id.radio2:
                        mVp.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mRadio = (RadioButton) findViewById(R.id.radio);
        mRadio1 = (RadioButton) findViewById(R.id.radio1);
        mRadio2 = (RadioButton) findViewById(R.id.radio2);
        mRg = (RadioGroup) findViewById(R.id.rg);
    }
}
