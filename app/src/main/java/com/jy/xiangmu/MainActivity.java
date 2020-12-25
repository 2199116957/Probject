package com.jy.xiangmu;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jy.xiangmu.fragment.CartFragment;
import com.jy.xiangmu.fragment.HomeFragment;
import com.jy.xiangmu.fragment.MeFragment;
import com.jy.xiangmu.fragment.SortFragment;
import com.jy.xiangmu.fragment.SpecialFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFl;
    private RadioButton mHome;
    private RadioButton mSpecial;
    private RadioButton mSort;
    private RadioButton mCart;
    private RadioButton mMy;
    private FragmentManager supportFragmentManager;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRg = (RadioGroup) findViewById(R.id.rg);
        mFl = (FrameLayout) findViewById(R.id.fl);
        mHome = (RadioButton) findViewById(R.id.home);
        mSpecial = (RadioButton) findViewById(R.id.special);
        mSort = (RadioButton) findViewById(R.id.sort);
        mCart = (RadioButton) findViewById(R.id.cart);
        mMy = (RadioButton) findViewById(R.id.my);
        supportFragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();
        SpecialFragment specialFragment = new SpecialFragment();
        SortFragment sortFragment = new SortFragment();
        CartFragment cartFragment = new CartFragment();
        MeFragment meFragment = new MeFragment();

        supportFragmentManager.beginTransaction()
                .add(R.id.fl,homeFragment)
                .add(R.id.fl,specialFragment)
                .add(R.id.fl,sortFragment)
                .add(R.id.fl,cartFragment)
                .add(R.id.fl,meFragment)
                .hide(specialFragment)
                .hide(sortFragment)
                .hide(cartFragment)
                .hide(meFragment)
                .commit();
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home:
                        supportFragmentManager.beginTransaction()
                                .show(homeFragment)
                                .hide(specialFragment)
                                .hide(sortFragment)
                                .hide(cartFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.special:
                        supportFragmentManager.beginTransaction()
                                .show(specialFragment)
                                .hide(homeFragment)
                                .hide(sortFragment)
                                .hide(cartFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.sort:
                        supportFragmentManager.beginTransaction()
                                .show(sortFragment)
                                .hide(specialFragment)
                                .hide(homeFragment)
                                .hide(cartFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.cart:
                        supportFragmentManager.beginTransaction()
                                .show(cartFragment)
                                .hide(specialFragment)
                                .hide(sortFragment)
                                .hide(homeFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.my:
                        supportFragmentManager.beginTransaction()
                                .show(meFragment)
                                .hide(specialFragment)
                                .hide(sortFragment)
                                .hide(cartFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                }
            }
        });

    }
}