package com.bawei.chenshuaishuaiyuekaomoni02.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.chenshuaishuaiyuekaomoni02.R;
import com.bawei.chenshuaishuaiyuekaomoni02.adapter.MyAdapter;
import com.bawei.chenshuaishuaiyuekaomoni02.base.BaseFragment;
import com.bawei.chenshuaishuaiyuekaomoni02.contract.ShopContract;
import com.bawei.chenshuaishuaiyuekaomoni02.model.entity.FlowEntity;
import com.bawei.chenshuaishuaiyuekaomoni02.model.entity.GridEntity;
import com.bawei.chenshuaishuaiyuekaomoni02.presenter.ShopPresenter;
import com.bawei.chenshuaishuaiyuekaomoni02.utils.VolleyUtils;
import com.bawei.chenshuaishuaiyuekaomoni02.weiget.FlowLayout;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements ShopContract.IView {

    private FlowLayout flo;
    private EditText edtext;
    private Button btnn;
    private ShopPresenter presenter;
    private RecyclerView recy;

    @Override
    protected void initview(View inflate) {
        flo = (FlowLayout)inflate.findViewById(R.id.flo);
        edtext = (EditText)inflate. findViewById(R.id.edtext);
        btnn = (Button)inflate. findViewById(R.id.btnn);
        recy = (RecyclerView)inflate.findViewById(R.id.recy);

        flo.setClickflow(new FlowLayout.Clickflow() {
            @Override
            public void clc(String keyword) {
                String encode = URLEncoder.encode(keyword);
                final String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+encode+"&count=10&page=1";

                VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallBack() {
                    @Override
                    public void success(String response) {
                        GridEntity gridEntity = new Gson().fromJson(response, GridEntity.class);
                        List<GridEntity.ResultBean> result = gridEntity.result;
                        MyAdapter myAdapter = new MyAdapter(getActivity(), result);
                        recy.setAdapter(myAdapter);
                    }
                    @Override
                    public void error(Throwable throwable) {

                    }
                });
            }
        });
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtext.getText().toString())){
                    Toast.makeText(getActivity(), "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                flo.addd(edtext.getText().toString());
                String encode = URLEncoder.encode(edtext.getText().toString());
                final String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+encode+"&count=10&page=1";

                VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallBack() {
                    @Override
                    public void success(String response) {
                        GridEntity gridEntity = new Gson().fromJson(response, GridEntity.class);
                        List<GridEntity.ResultBean> result = gridEntity.result;
                        MyAdapter myAdapter = new MyAdapter(getActivity(), result);
                        recy.setAdapter(myAdapter);
                    }
                    @Override
                    public void error(Throwable throwable) {

                    }
                });
            }
        });
    }
    @Override
    protected int layoutid() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initdata() {
        recy.setLayoutManager(new GridLayoutManager(getActivity(),2));
       presenter=new ShopPresenter(this);
        String encode = URLEncoder.encode("手机");
        String url="http://blog.zhaoliang5156.cn/baweiapi/"+encode;
       presenter.getFlow(url);
    }
    @Override
    public void success(FlowEntity flowEntity) {
        List<String> tags = flowEntity.getTags();
        flo.addView(tags);
    }
    @Override
    public void error(Throwable throwable) {

    }
}
