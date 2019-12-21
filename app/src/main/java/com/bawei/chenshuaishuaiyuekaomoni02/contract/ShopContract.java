package com.bawei.chenshuaishuaiyuekaomoni02.contract;

import com.bawei.chenshuaishuaiyuekaomoni02.model.entity.FlowEntity;

public interface ShopContract {
    interface IModel{
        void getFlow(String url,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(FlowEntity flowEntity);
            void error(Throwable throwable);
        }

    }
    interface IView{
        void success(FlowEntity flowEntity);
        void error(Throwable throwable);


    }
    interface IPresenter{
        void getFlow(String url);
    }

}
