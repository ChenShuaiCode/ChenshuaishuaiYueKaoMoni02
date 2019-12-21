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
public class MyFragment extends BaseFragment {


    private TextView t2;

    @Override
    protected void initview(View inflate) {
        t2 = (TextView)inflate. findViewById(R.id.t2);

    }

    @Override
    protected int layoutid() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initdata() {
        t2.setText(getArguments().getString("wode"));

    }
}
