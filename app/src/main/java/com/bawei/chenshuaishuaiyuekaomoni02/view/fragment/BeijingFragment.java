package com.bawei.chenshuaishuaiyuekaomoni02.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.chenshuaishuaiyuekaomoni02.R;
import com.bawei.chenshuaishuaiyuekaomoni02.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeijingFragment extends BaseFragment {


    private TextView ti;

    @Override
    protected void initview(View inflate) {
        ti = (TextView)inflate. findViewById(R.id.t1);

    }

    @Override
    protected int layoutid() {
        return R.layout.fragment_beijing;
    }

    @Override
    protected void initdata() {
        String beijing = getArguments().getString("beijing");
        ti.setText(beijing);
    }
}