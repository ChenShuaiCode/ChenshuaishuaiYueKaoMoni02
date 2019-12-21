package com.bawei.chenshuaishuaiyuekaomoni02.model;

import com.bawei.chenshuaishuaiyuekaomoni02.contract.ShopContract;
import com.bawei.chenshuaishuaiyuekaomoni02.model.entity.FlowEntity;
import com.bawei.chenshuaishuaiyuekaomoni02.utils.VolleyUtils;
import com.google.gson.Gson;

public class ShopModel implements ShopContract.IModel {
    @Override
    public void getFlow(String url, final ModelCallBack modelCallBack) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallBack() {
            @Override
            public void success(String response) {
                FlowEntity flowEntity = new Gson().fromJson(response, FlowEntity.class);
                modelCallBack.success(flowEntity);
            }
            @Override
            public void error(Throwable throwable) {
                modelCallBack.error(throwable);
            }
        });
    }
}
