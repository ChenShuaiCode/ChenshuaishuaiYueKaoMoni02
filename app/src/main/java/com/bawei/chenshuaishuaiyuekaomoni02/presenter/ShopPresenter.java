package com.bawei.chenshuaishuaiyuekaomoni02.presenter;

import com.bawei.chenshuaishuaiyuekaomoni02.contract.ShopContract;
import com.bawei.chenshuaishuaiyuekaomoni02.model.ShopModel;
import com.bawei.chenshuaishuaiyuekaomoni02.model.entity.FlowEntity;

public class ShopPresenter implements ShopContract.IPresenter {
    private ShopContract.IView iView;
    private ShopModel model;

    public ShopPresenter(ShopContract.IView iView) {
        this.iView = iView;
        model=new ShopModel();
    }
    @Override
    public void getFlow(String url) {
        model.getFlow(url, new ShopContract.IModel.ModelCallBack() {
            @Override
            public void success(FlowEntity flowEntity) {
                iView.success(flowEntity);
            }

            @Override
            public void error(Throwable throwable) {
                iView.error(throwable);
            }
        });
    }
}
