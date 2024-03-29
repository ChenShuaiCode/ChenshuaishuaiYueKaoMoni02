package com.bawei.chenshuaishuaiyuekaomoni02.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutid());
        initview();
        initdata();
    }

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract int layoutid();
}
